package com.example.yemeksiparis.ui.viewmodel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.yemeksiparis.data.entity.Foods;
import com.example.yemeksiparis.data.repo.FoodsDaoRepository;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.lifecycle.HiltViewModel;

@HiltViewModel
public class FoodViewModel extends ViewModel {

    public MutableLiveData<List<Foods>> foodList = new MutableLiveData<>();
    private FoodsDaoRepository frepo;

    @Inject
    public FoodViewModel(FoodsDaoRepository frepo){
        this.frepo = frepo;
        yemekleriYukle();
        foodList = frepo.getFoodList();
    }

    public void ara(String aramaKelimesi){
        frepo.ara(aramaKelimesi);
    }

    public void sil(int yemek_id){
        frepo.sil(yemek_id);
    }

    public void yemekleriYukle(){
        frepo.yemekleriYukle();
    }
}
