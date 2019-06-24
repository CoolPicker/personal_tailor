package com.rosetta.tailor.entity;

public class CityCompetitiveness {
    private Integer id;

    private String city;

    private Double economicCompetitiveness;

    private Integer economicRanking;

    private Double sustainableCompetitiveness;

    private Integer sustainableRanking;

    private Double livableCompetitiveness;

    private Integer livableRanking;

    private Double businessEnvironmentCompetitiveness;

    private Integer businessEnvironmentRanking;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public Double getEconomicCompetitiveness() {
        return economicCompetitiveness;
    }

    public void setEconomicCompetitiveness(Double economicCompetitiveness) {
        this.economicCompetitiveness = economicCompetitiveness;
    }

    public Integer getEconomicRanking() {
        return economicRanking;
    }

    public void setEconomicRanking(Integer economicRanking) {
        this.economicRanking = economicRanking;
    }

    public Double getSustainableCompetitiveness() {
        return sustainableCompetitiveness;
    }

    public void setSustainableCompetitiveness(Double sustainableCompetitiveness) {
        this.sustainableCompetitiveness = sustainableCompetitiveness;
    }

    public Integer getSustainableRanking() {
        return sustainableRanking;
    }

    public void setSustainableRanking(Integer sustainableRanking) {
        this.sustainableRanking = sustainableRanking;
    }

    public Double getLivableCompetitiveness() {
        return livableCompetitiveness;
    }

    public void setLivableCompetitiveness(Double livableCompetitiveness) {
        this.livableCompetitiveness = livableCompetitiveness;
    }

    public Integer getLivableRanking() {
        return livableRanking;
    }

    public void setLivableRanking(Integer livableRanking) {
        this.livableRanking = livableRanking;
    }

    public Double getBusinessEnvironmentCompetitiveness() {
        return businessEnvironmentCompetitiveness;
    }

    public void setBusinessEnvironmentCompetitiveness(Double businessEnvironmentCompetitiveness) {
        this.businessEnvironmentCompetitiveness = businessEnvironmentCompetitiveness;
    }

    public Integer getBusinessEnvironmentRanking() {
        return businessEnvironmentRanking;
    }

    public void setBusinessEnvironmentRanking(Integer businessEnvironmentRanking) {
        this.businessEnvironmentRanking = businessEnvironmentRanking;
    }
}