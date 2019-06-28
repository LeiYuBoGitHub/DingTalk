package com.dingtalk;

/**
 * @Auther: 野性的呼唤
 * @Date: 2019/6/27 18:32
 * @Description:
 */
public class SendResult {

    private boolean success;

    private Integer errorCode;

    private String errorMessage;

    public boolean isSuccess() {
        return success;
    }

    void setSuccess(boolean success) {
        this.success = success;
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
