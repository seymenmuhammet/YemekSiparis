package com.example.yemeksiparis.data.repo;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.yemeksiparis.data.entity.Foods;
import com.example.yemeksiparis.data.entity.FoodsCevap;
import com.example.yemeksiparis.data.entity.SepetYemekler;
import com.example.yemeksiparis.data.entity.SepetYemeklerCevap;
import com.example.yemeksiparis.retrofit.FoodsDao;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FoodsDaoRepository {

    private MutableLiveData<List<Foods>> foodList;
    private MutableLiveData<List<SepetYemekler>> basketList;
    private FoodsDao fdao;



    public FoodsDaoRepository(FoodsDao fdao){
        this.fdao = fdao;
        foodList = new MutableLiveData();
        basketList = new MutableLiveData();
    }

    public MutableLiveData<List<SepetYemekler>> getBasketList() {
        return basketList;
    }

    public void setBasketList(MutableLiveData<List<SepetYemekler>> basketList) {
        this.basketList = basketList;
    }

    public MutableLiveData<List<Foods>> getFoodList(){
        return foodList;
    }


    public void yemekleriYukle(){
        fdao.yemekleriYukle().enqueue(new Callback<FoodsCevap>() {
            @Override
            public void onResponse(Call<FoodsCevap> call, Response<FoodsCevap> response) {
                List<Foods> list = response.body().getFoods();
                foodList.setValue(list);
            }

            @Override
            public void onFailure(Call<FoodsCevap> call, Throwable t) {}
        });
    }

    public void sepeteEkle(String yemek_adi,String yemek_resim_adi,int yemek_fiyat, int yemek_siparis_adet, String kullanici_adi) {
        fdao.sepeteEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi).enqueue(new Callback<SepetYemeklerCevap>() {
            @Override
            public void onResponse(Call<SepetYemeklerCevap> call, Response<SepetYemeklerCevap> response) {
                Log.e("Sepete Ekle Fonk: ", yemek_adi);
            }

            @Override
            public void onFailure(Call<SepetYemeklerCevap> call, Throwable t) {
                Log.e("Hatalı Sepett: ", t.toString());
            }
        });
    }

    public void sepettekiYemekleriGetir(String kullanici_adi){
        fdao.sepettekiYemekleriGetir(kullanici_adi).enqueue(new Callback<SepetYemeklerCevap>() {
            @Override
            public void onResponse(Call<SepetYemeklerCevap> call, Response<SepetYemeklerCevap> response) {
                List<SepetYemekler> list = response.body().getSepetYemeklerList();
                basketList.setValue(list);
            }

            @Override
            public void onFailure(Call<SepetYemeklerCevap> call, Throwable t) {

            }
        });
    }

    public void ara(String aramaKelimesi){

        Log.e("Yemek Ara:",aramaKelimesi);
    }

    public void sil(int yemek_id){

        Log.e("Yemek Sil:",String.valueOf(yemek_id));
    }
}
