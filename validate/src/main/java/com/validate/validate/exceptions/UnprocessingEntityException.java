package com.validate.validate.exceptions;

public class UnprocessingEntityException extends Exception {
    private String messager;
    private Integer statusCode;
    private String methodName;

    public UnprocessingEntityException(String messager) {
        super(messager);
        this.messager = messager;
    }
    public UnprocessingEntityException(String messager, Integer statusCode, String methodName) {
        super(messager);
        this.messager = messager;
        this.statusCode = statusCode;
        this.methodName = methodName;
    }

    public String getMessager() {
        return messager;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public String getMethodName() {
        return methodName;
    }
}
