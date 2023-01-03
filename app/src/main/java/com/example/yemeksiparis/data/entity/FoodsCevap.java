package com.example.yemeksiparis.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FoodsCevap {
    @SerializedName("yemekler")
    private List<Foods> foods;
    @SerializedName("succes")
    private int success;

    public FoodsCevap() {
    }

    public FoodsCevap(List<Foods> foods, int success) {
        this.foods = foods;
        this.success = success;
    }

    public List<Foods> getFoods() {
        return foods;
    }

    public void setFoods(List<Foods> foods) {
        this.foods = foods;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
