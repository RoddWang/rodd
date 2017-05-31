package com.suse.www.entity;

public class TFoodCountry {
    private Integer id;

    private String foodCountry;

    private String foodCountryName;

    private String isCancel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodCountry() {
        return foodCountry;
    }

    public void setFoodCountry(String foodCountry) {
        this.foodCountry = foodCountry == null ? null : foodCountry.trim();
    }

    public String getFoodCountryName() {
        return foodCountryName;
    }

    public void setFoodCountryName(String foodCountryName) {
        this.foodCountryName = foodCountryName == null ? null : foodCountryName.trim();
    }

    public String getIsCancel() {
        return isCancel;
    }

    public void setIsCancel(String isCancel) {
        this.isCancel = isCancel == null ? null : isCancel.trim();
    }
}