package com.example.yemeksiparis.ui.fragment;

import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yemeksiparis.R;
import com.example.yemeksiparis.data.entity.SepetYemekler;
import com.example.yemeksiparis.databinding.FragmentBasketBinding;
import com.example.yemeksiparis.databinding.FragmentDetailBinding;
import com.example.yemeksiparis.ui.adapter.BasketAdapter;
import com.example.yemeksiparis.ui.viewmodel.BasketViewModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class BasketFragment extends Fragment {
    private FragmentBasketBinding binding;
    private BasketViewModel basketViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBasketBinding.inflate(inflater ,container, false);
        binding.setBasketToolbarBaslik("Yemek Sepeti");


        binding.rvBasket.setLayoutManager(new LinearLayoutManager(requireContext()));


        ArrayList<SepetYemekler> denemeList = new ArrayList<>();
        SepetYemekler d1 = new SepetYemekler(1,"Ayran","ayran.png",3,2,"");
        denemeList.add(d1);


        BasketAdapter adapter = new BasketAdapter(requireContext(),denemeList,basketViewModel);
        binding.rvBasket.setAdapter(adapter);


        //Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/"+gelenFood.getYemek_resim_adi()).into(binding.imageView);


        binding.setBasketFragment(this);
        return binding.getRoot();
    }


}