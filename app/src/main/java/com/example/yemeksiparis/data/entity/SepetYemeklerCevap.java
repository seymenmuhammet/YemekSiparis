package com.example.yemeksiparis.data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SepetYemeklerCevap {
    @SerializedName("yemekler")
    private List<SepetYemekler> sepetYemeklerList;
    @SerializedName("succes")
    private int success;

    public SepetYemeklerCevap() {
    }

    public SepetYemeklerCevap(List<SepetYemekler> sepetYemeklerList, int success) {
        this.sepetYemeklerList = sepetYemeklerList;
        this.success = success;
    }

    public List<SepetYemekler> getSepetYemeklerList() {
        return sepetYemeklerList;
    }

    public void setSepetYemeklerList(List<SepetYemekler> sepetYemeklerList) {
        this.sepetYemeklerList = sepetYemeklerList;
    }

    public int getSuccess() {
        return success;
    }

    public void setSuccess(int success) {
        this.success = success;
    }
}
