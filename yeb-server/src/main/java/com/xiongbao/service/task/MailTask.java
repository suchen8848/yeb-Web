package com.xiongbao.service.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.xiongbao.service.pojo.Employee;
import com.xiongbao.service.pojo.MailConstants;
import com.xiongbao.service.pojo.MailLog;
import com.xiongbao.service.service.IEmployeeService;
import com.xiongbao.service.service.IMailLogService;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Su Chen
 * @Date: 2022/04/24/9:11
 *
 *  邮件发送定时任务
 */
@Component
public class MailTask {

    @Autowired
    private IMailLogService mailLogService;
    @Autowired
    private IEmployeeService employeeService;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /*
    *  邮件发送定时任务
    *   每10秒发送一次
    *
    * */
    @Scheduled(cron = "0/10 * * * * ?")
    public void mailTask(){
        List<MailLog> list = mailLogService.list(new QueryWrapper<MailLog>().eq("status", 0).lt("tryTime",
                LocalDateTime.now()));
        list.forEach(mailLog -> {
            // 如果重试次数超过3次,更新状态为投递失败, 不在重试
            if (3<=mailLog.getCount()){
                mailLogService.update(new UpdateWrapper<MailLog>().set("status",2).eq("msgId",mailLog
                        .getMsgId()));
            }
            mailLogService.update(new UpdateWrapper<MailLog>().set("count",mailLog.getCount()+1)
                    .set("updateTime",LocalDateTime.now()).set("tryTime",LocalDateTime.now()
                            .plusMinutes(MailConstants.MSG_TIMEOUT)).eq("msgId",mailLog.getMsgId()));
            Employee emp = employeeService.getEmployee(mailLog.getEid()).get(0);
            // 发送消息
            rabbitTemplate.convertAndSend(MailConstants.MAX_EXCHANGE_NAME,MailConstants.MAIL_ROUTING_KEY_NAME,emp,
                    new CorrelationData(mailLog.getMsgId()));
        });
    }
}
