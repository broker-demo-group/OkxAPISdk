package org.okxbrokerdemo.exception;

/**
 * @author: bowen
 * @description:
 * @date: 2022/6/22  10:41 PM
 **/
public class OkxApiException extends RuntimeException {
    private int code;
    private String detailMsg;
    private final static long serialVersionUID = 996L;

    public OkxApiException(String message, int code) {
        super(message);
        this.code = code;
    }

    public OkxApiException(String message, Throwable e) {
        super(message, e);
    }

    public OkxApiException(Throwable e) {
        super(e);
    }

    @Override
    public String getMessage() {
        return " OkxApiAccessException:[code:"+code+" message:"+super.getMessage()+"]";
    }
}
