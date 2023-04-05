package com.xiongbao.service.pojo;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: Su Chen
 * @Date: 2022/04/23/23:25
 *  消息状态
 */
public class MailConstants {

    // 消息投递中 (常量)
    public static final Integer DELIVERING = 0;

    // 消息投递成功(常量)
    public static final Integer SUCCESS = 1;

    // 消息投递失败(常量)
    public static final Integer FAILURE = 2;

    // 最大尝试次数(常量)
    public static final Integer MAX_TRY_COUNT = 3;

    // 消息超时时间 (常量)
    public static final Integer MSG_TIMEOUT = 1;

    // 队列 (常量)
    public static final String MAIL_QUEUE_NAME = "mail.queue";

    // 交换机 (常量)
    public static final String MAX_EXCHANGE_NAME = "mail.exchange";

    // 路由键 (常量)
    public static final String MAIL_ROUTING_KEY_NAME = "mail.routing.key";
}
