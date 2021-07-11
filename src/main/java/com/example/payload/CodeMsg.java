package com.example.payload;

import com.sun.org.apache.bcel.internal.classfile.Code;

public class CodeMsg {

    private int code;
    private String msg;

    public static CodeMsg SUCCESS = new CodeMsg(0, "success");
    public static CodeMsg SERVER_ERROR = new CodeMsg(500100, "server error");

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
