package com.dingtalk;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/6/27 18:39
 * @Description:
 */
public class DingTalkConnectionBuilder implements DingTalkConnection {

    private String url = "";

    private String message;

    static DingTalkConnection custom() {
        return new DingTalkConnectionBuilder();
    }

    public SendResult send() {

        TextMessage textMessage = new TextMessage(this.message);
        String json = textMessage.toJsonString();

        HttpClient httpclient = HttpClients.createDefault();

        HttpPost httppost = new HttpPost(this.url);

        httppost.addHeader("Content-Type", "application/json; charset=utf-8");
        StringEntity se = new StringEntity(json, "utf-8");
        httppost.setEntity(se);

        HttpResponse response;

        try {
            response = httpclient.execute(httppost);

            SendResult sendResult = new SendResult();

            if (response.getStatusLine().getStatusCode() == 200) {
                String result = EntityUtils.toString(response.getEntity());
                JSONObject obj = JSONObject.parseObject(result);
                Integer errCode = obj.getInteger("errcode");
                sendResult.setErrorCode(errCode);
                sendResult.setErrorMessage(obj.getString("errmsg"));
                sendResult.setSuccess(errCode.equals(0));
            }

            return sendResult;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public DingTalkConnection setUrl(String url) {
        this.url = url;
        return this;
    }

    public DingTalkConnection setMessage(String message) {
        this.message = message;
        return this;
    }
}
