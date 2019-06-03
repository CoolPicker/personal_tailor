package com.rosetta.tailor.entity;

public class TailorUserEnhance extends TailorUser {

    private int pagenum;		//分页 起始页
    private int pagesize;		//页大小
    private String orderby;		//排序
    private String	desc;		//倒叙，不传为正序

    public int getPagenum() {
        return pagenum;
    }

    public void setPagenum(int pagenum) {
        this.pagenum = pagenum;
    }

    public int getPagesize() {
        return pagesize;
    }

    public void setPagesize(int pagesize) {
        this.pagesize = pagesize;
    }

    public String getOrderby() {
        return orderby;
    }

    public void setOrderby(String orderby) {
        this.orderby = orderby;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
