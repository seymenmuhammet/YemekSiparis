package com.example.yemeksiparis.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yemeksiparis.R;
import com.example.yemeksiparis.data.entity.Foods;
import com.example.yemeksiparis.databinding.CardTasarimBinding;
import com.example.yemeksiparis.ui.fragment.FoodFragment;
import com.example.yemeksiparis.ui.fragment.FoodFragmentDirections;
import com.example.yemeksiparis.ui.viewmodel.FoodViewModel;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.CardTasarimTutucu> {
    private Context mContext;
    private List<Foods> foodsList;
    private FoodViewModel viewModel;

    public FoodsAdapter(Context mContext, List<Foods> foodsList, FoodViewModel viewModel) {
        this.mContext = mContext;
        this.foodsList = foodsList;
        this.viewModel = viewModel;
    }

    public class CardTasarimTutucu extends RecyclerView.ViewHolder {
        private CardTasarimBinding binding;

        public CardTasarimTutucu(CardTasarimBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public CardTasarimTutucu onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        CardTasarimBinding binding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.card_tasarim, parent, false);
        return new CardTasarimTutucu(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CardTasarimTutucu holder, int position) {
        Foods food = foodsList.get(position);
        CardTasarimBinding t = holder.binding;
        t.setFoodNesnesi(food);

        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/"+food.getYemek_resim_adi()).into(t.imageViewYemekResmi);
        t.satirCard.setOnClickListener(view -> {
            FoodFragmentDirections.DetailGecis gecis = FoodFragmentDirections.detailGecis(food);
            Navigation.findNavController(view).navigate(gecis);
        });

    }


    @Override
    public int getItemCount() {
        return foodsList.size();
    }
}
