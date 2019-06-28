package com.dingtalk;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/6/27 18:39
 * @Description:
 */
public interface DingTalkConnection {

    SendResult send();

    DingTalkConnection setUrl(String url);

    DingTalkConnection setMessage(String message);



}
