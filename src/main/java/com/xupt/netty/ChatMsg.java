package com.xupt.netty;

import lombok.Data;
import java.io.Serializable;

@Data
public class ChatMsg implements Serializable {

    private static final long serialVersionUID = 3611169682695799175L;
    // 发送者的用户id
    private String senderId;
    // 接受者的用户id
    private String receiverId;
    // 聊天内容
    private String msg;
    // 用于消息的签收
    private String msgId;

}
