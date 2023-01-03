package com.example.yemeksiparis.retrofit;

public class ApiUtils {
    public static final String BASE_URL = "http://kasimadalan.pe.hu/";
    public static final String KULLANICI_ADI = "muhammet_seymen";

    public static FoodsDao getFoodsDao(){
        return RetrofitClient.getClient(BASE_URL).create(FoodsDao.class);
    }
}
