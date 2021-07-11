package com.example.controller;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class RestResponse implements Serializable {

    private final static int STATUS_SUCCESS = 200;

    private final static int STATUS_ERROR_INTERNAL_SERVER_ERROR = 500;

    private final static int STATUS_ERROR_SERVICE_UNAVAILABLE = 503;

    private int status;
    private Object data;
    private String message;
    @JsonFormat(pattern = "yyyy-MM-dd hh:mm:ss", locale = "lz", timezone = "GMT+8")
    private Date timestamp;

    public RestResponse(int code, String message, Object data) {
        this.status = code;
        this.message = message;
        this.data = data;
    }

    public static RestResponse buildSuccess(Object data) {
        return new RestResponse(STATUS_SUCCESS, "success", data);
    }

    public static RestResponse buildInternalErr(Object data) {
        return new RestResponse(STATUS_ERROR_INTERNAL_SERVER_ERROR, "Internal Error", data);
    }

    public static  RestResponse buildUnavailable(Object data) {
        return new RestResponse(STATUS_ERROR_SERVICE_UNAVAILABLE, "Service Unavailable", data);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return new Date();
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
