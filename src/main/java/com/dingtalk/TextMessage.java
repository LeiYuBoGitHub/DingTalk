package com.dingtalk;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/6/27 18:28
 * @Description:
 */
public class TextMessage implements Message {

    private String text;

    private List<String> atMobiles;

    private boolean isAtAll;

    TextMessage(String text) {
        this.text = text;
    }

    public String toJsonString() {
        Map<String, Object> items = new HashMap<>();
        items.put("msgtype", "text");
        Map<String, String> textContent = new HashMap<>();
        if (StringUtil.isBlank(this.text)) {
            throw new IllegalArgumentException("文本不能为空!");
        } else {
            textContent.put("content", this.text);
            items.put("text", textContent);
            Map<String, Object> atItems = new HashMap<>();
            if (this.atMobiles != null && !this.atMobiles.isEmpty()) {
                atItems.put("atMobiles", this.atMobiles);
            }

            if (this.isAtAll) {
                atItems.put("isAtAll", true);
            }

            items.put("at", atItems);
            return JSONObject.toJSONString(items);
        }
    }
}
