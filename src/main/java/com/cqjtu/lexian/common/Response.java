package com.cqjtu.lexian.common;

import lombok.Data;

import java.io.Serializable;

@Data
public class Response implements Serializable {
    private int status;
    private String msg;
    private Object data;

    public static Response isSuccess() {
        return new Response().status(200).msg("Success!");
    }

    public static Response isFail() {
        return new Response().status(500).msg("Fail!");
    }

    public Response msg(String msg){
        this.setMsg(msg);
        return this;
    }

    public Response msg(Throwable e) {
        this.setMsg(e.toString());
        return this;
    }

    public Response data(Object data) {
        this.setData(data);
        return this;
    }

    public Response status(int status) {
        this.setStatus(status);
        return this;
    }
}