package com.dingtalk;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/6/27 18:30
 * @Description:
 */
class StringUtil {

    static boolean isBlank(CharSequence cs) {
        int strLen;
        if (cs != null && (strLen = cs.length()) != 0) {
            for(int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }
}
