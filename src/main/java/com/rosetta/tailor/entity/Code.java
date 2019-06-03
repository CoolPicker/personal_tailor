package com.rosetta.tailor.entity;

public enum Code {
    SUCCESS("101","成功"),
    FALI("102","失败");

    private String code;
    private String msg;
    private Code(String code,String msg) {
        this.code=code;
        this.msg=msg;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
