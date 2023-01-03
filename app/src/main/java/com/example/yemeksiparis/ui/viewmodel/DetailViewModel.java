package com.example.yemeksiparis.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.yemeksiparis.data.repo.FoodsDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class DetailViewModel extends ViewModel {
    private FoodsDaoRepository frepo;


    @Inject
    public DetailViewModel(FoodsDaoRepository frepo){
        this.frepo = frepo;
    }

    public void sepeteEkle(String yemek_adi,String yemek_resim_adi,int yemek_fiyat, int yemek_siparis_adet, String kullanici_adi) {
        frepo.sepeteEkle(yemek_adi,yemek_resim_adi,yemek_fiyat,yemek_siparis_adet,kullanici_adi);
    }
}
