package com.weixin.comm.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * 异常处理类
 * @author JINLONG
 *
 */
public class WebChatException extends RuntimeException {

    public static EasyTomExceptionBuilder newBuilder(String message) {
        return newBuilder(message, null);
    }

    public static EasyTomExceptionBuilder newBuilder(Throwable cause) {
        return newBuilder("", cause);
    }

    public static EasyTomExceptionBuilder newBuilder() {
        return newBuilder("", null);
    }

    public static EasyTomExceptionBuilder newBuilder(String message, Throwable cause) {
        return new EasyTomExceptionBuilder(message, cause);
    }

    private static final long serialVersionUID = 5099827279044223975L;


    WebChatException() {
        super();
    }

    WebChatException(String message) {
        super(message);
    }

    WebChatException(Throwable cause) {
        super(cause);
    }

    WebChatException(String message, Throwable cause) {
        super(message, cause);
    }

    public static WebChatException raise(String message) {
        return new WebChatException(message);
    }

    public static WebChatException raise(Throwable cause) {
        return new WebChatException(cause);
    }

    public static WebChatException raise(String message, Throwable cause) {
        return new WebChatException(message, cause);
    }

    public static class EasyTomExceptionBuilder {
        private final Map<String, Object> contextInfos =new HashMap<String,Object>();

        private final Throwable cause;

        private final String currentMessage;

        EasyTomExceptionBuilder(String message, Throwable cause) {
            this.currentMessage = message;
            this.cause = cause;
        }

        EasyTomExceptionBuilder(Throwable cause) {
            this("", cause);
        }

        EasyTomExceptionBuilder(String message) {
            this(message, null);
        }

        /**
         * 给异常增加上下文变量信息。
         * @param name 变量名
         * @param value 变量值
         * @return 自身
         */
        public EasyTomExceptionBuilder addContextVariable(String name, Object value) {
            contextInfos.put(name, value);
            return this;
        }

        public EasyTomExceptionBuilder addContextVariables(Map<?, ?> variables) {
            for (Map.Entry entry : variables.entrySet())
                addContextVariable(entry.toString(), entry.getValue());

            return this;
        }

        /**
         * 创建一个EasyTomException
         */
        public WebChatException build() {
            return new WebChatException(getContextInfo(), cause);
        }

        /**
         * throw
         * @param clazz
         * @param <T>
         * @return
         */
        public <T> T raise(Class<T> clazz) {
            throw build();
        }

        private String getContextInfo() {
            return this.currentMessage +
                    (contextInfos.size() > 0  ?  "\ncontext: "  + contextInfos.toString()
                            : "");
        }
    }
}