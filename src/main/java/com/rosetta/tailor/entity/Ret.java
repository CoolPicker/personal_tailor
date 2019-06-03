package com.rosetta.tailor.entity;

public class Ret {
    private String code;
    private String msg;
    private Object data;

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public void setState(Code code) {
        this.code = code.getCode();
        this.msg = code.getMsg();
    }
    public void setState(String code,String msg) {
        this.code = code;
        this.msg = msg;
    }
    public static Ret defaultFactory() {
        Ret ret = new Ret();
        ret.setState(Code.SUCCESS);
        return ret;
    }
    public static Ret defaultFactory(Code code) {
        Ret ret = new Ret();
        ret.setState(code);
        return ret;
    }
}
