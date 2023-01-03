package com.example.yemeksiparis.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yemeksiparis.R;
import com.example.yemeksiparis.data.entity.Foods;
import com.example.yemeksiparis.data.entity.SepetYemekler;
import com.example.yemeksiparis.databinding.BasketCardTasarimBinding;
import com.example.yemeksiparis.databinding.CardTasarimBinding;
import com.example.yemeksiparis.ui.fragment.BasketFragment;
import com.example.yemeksiparis.ui.viewmodel.BasketViewModel;
import com.example.yemeksiparis.ui.viewmodel.FoodViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.List;

public class BasketAdapter extends RecyclerView.Adapter<BasketAdapter.CardTasarimBasket> {
    private Context mContext;
    private List<SepetYemekler> sepetYemeklerList;
    private BasketViewModel basketViewModel;
    private BasketFragment basketFragment;

    public BasketAdapter(Context mContext, List<SepetYemekler> sepetYemeklerList, BasketViewModel basketViewModel) {
        this.mContext = mContext;
        this.sepetYemeklerList = sepetYemeklerList;
        this.basketViewModel = basketViewModel;
    }



    public class CardTasarimBasket extends RecyclerView.ViewHolder{
        private BasketCardTasarimBinding binding;

        public CardTasarimBasket(BasketCardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimBasket onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BasketCardTasarimBinding binding =
                BasketCardTasarimBinding.inflate(LayoutInflater.from(mContext), parent,false);
        return new CardTasarimBasket(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimBasket holder, int position) {
        SepetYemekler sepetYemekler = sepetYemeklerList.get(position);
        BasketCardTasarimBinding basketCardTasarim = holder.binding;

        basketCardTasarim.imageViewYemekSil.setOnClickListener(view -> {
            Snackbar.make(view,sepetYemekler.getYemek_adi() + " silinsin mi?",Snackbar.LENGTH_LONG)
                    .setAction("EVET", view1 -> {

                    }).show();
        });

        basketCardTasarim.textViewSepetYemekAdi.setText(sepetYemekler.getYemek_adi());
        basketCardTasarim.textViewSepetAdet.setText(sepetYemekler.getYemek_siparis_adet()+" Adet");


        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/"+sepetYemekler.getYemek_resim_adi()).into(basketCardTasarim.imageViewSepetResim);
        /*Foods food = foodsList.get(position);
        CardTasarimBinding t = holder.binding;
        t.setFoodNesnesi(food);*/

    }

    @Override
    public int getItemCount() {
        return sepetYemeklerList.size();
    }
}
