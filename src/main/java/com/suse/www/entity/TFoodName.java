package com.suse.www.entity;

import java.math.BigDecimal;

public class TFoodName {
    private Long id;

    private Long foddCountryId;

    private Long foodTypeId;

    private String foodNameCode;

    private String foodName;

    private String isSale;

    private BigDecimal discountPercent;

    private String isNew;

    private BigDecimal price;

    private BigDecimal discountPrice;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFoddCountryId() {
        return foddCountryId;
    }

    public void setFoddCountryId(Long foddCountryId) {
        this.foddCountryId = foddCountryId;
    }

    public Long getFoodTypeId() {
        return foodTypeId;
    }

    public void setFoodTypeId(Long foodTypeId) {
        this.foodTypeId = foodTypeId;
    }

    public String getFoodNameCode() {
        return foodNameCode;
    }

    public void setFoodNameCode(String foodNameCode) {
        this.foodNameCode = foodNameCode == null ? null : foodNameCode.trim();
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName == null ? null : foodName.trim();
    }

    public String getIsSale() {
        return isSale;
    }

    public void setIsSale(String isSale) {
        this.isSale = isSale == null ? null : isSale.trim();
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    public String getIsNew() {
        return isNew;
    }

    public void setIsNew(String isNew) {
        this.isNew = isNew == null ? null : isNew.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(BigDecimal discountPrice) {
        this.discountPrice = discountPrice;
    }
}