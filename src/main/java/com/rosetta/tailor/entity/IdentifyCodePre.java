package com.rosetta.tailor.entity;

public class IdentifyCodePre {
    private Integer id;

    private Integer sixCode;
    private Integer twoCode;

    private Integer fourCode;

    private String certificateArea;

    private String identifyProvince;

    private String identifyCity;

    private String identifyArea;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSixCode() {
        return sixCode;
    }

    public void setSixCode(Integer sixCode) {
        this.sixCode = sixCode;
    }

    public Integer getFourCode() {
        return fourCode;
    }

    public void setFourCode(Integer fourCode) {
        this.fourCode = fourCode;
    }

    public String getCertificateArea() {
        return certificateArea;
    }

    public void setCertificateArea(String certificateArea) {
        this.certificateArea = certificateArea == null ? null : certificateArea.trim();
    }

    public Integer getTwoCode() {
        return twoCode;
    }

    public void setTwoCode(Integer twoCode) {
        this.twoCode = twoCode;
    }

    public String getIdentifyProvince() {
        return identifyProvince;
    }

    public void setIdentifyProvince(String identifyProvince) {
        this.identifyProvince = identifyProvince == null ? null : identifyProvince.trim();
    }

    public String getIdentifyCity() {
        return identifyCity;
    }

    public void setIdentifyCity(String identifyCity) {
        this.identifyCity = identifyCity == null ? null : identifyCity.trim();
    }

    public String getIdentifyArea() {
        return identifyArea;
    }

    public void setIdentifyArea(String identifyArea) {
        this.identifyArea = identifyArea == null ? null : identifyArea.trim();
    }
}