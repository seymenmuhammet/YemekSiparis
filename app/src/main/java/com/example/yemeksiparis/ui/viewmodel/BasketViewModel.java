package com.example.yemeksiparis.ui.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.yemeksiparis.data.repo.FoodsDaoRepository;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class BasketViewModel extends ViewModel {
    private FoodsDaoRepository frepo;

    @Inject
    public BasketViewModel(FoodsDaoRepository frepo){
        this.frepo = frepo;
    }

    public void sepettekiYemekleriGetir(String kullanici_adi){
        frepo.sepettekiYemekleriGetir(kullanici_adi);
    }


}
