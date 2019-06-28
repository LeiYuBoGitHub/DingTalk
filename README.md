## DingTalk

简单的钉钉机器人接口,通过地址和消息实现机器人在群内发送指定内容

使用方法(示例):

```
public static void main(String[] args) {

        SendResult sendResult = DingTalk.custom()
                .setUrl("")
                .setMessage("测试消息201906281345")
                .send();

        System.out.println(JSONObject.toJSONString(sendResult));
}

```

输出:
```
{"errorCode":0,"errorMessage":"ok","success":true}
```