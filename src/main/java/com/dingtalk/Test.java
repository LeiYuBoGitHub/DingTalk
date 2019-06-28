package com.dingtalk;

import com.alibaba.fastjson.JSONObject;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/6/28 13:34
 * @Description:
 */
public class Test {

    public static void main(String[] args) {

        SendResult sendResult = DingTalk.custom()
                .setUrl("")
                .setMessage("测试消息201906281345")
                .send();

        System.out.println(JSONObject.toJSONString(sendResult));
    }
}
