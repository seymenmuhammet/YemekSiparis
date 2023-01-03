package com.example.yemeksiparis.ui.fragment;

import static com.example.yemeksiparis.retrofit.ApiUtils.KULLANICI_ADI;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.telephony.mbms.MbmsErrors;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.yemeksiparis.R;
import com.example.yemeksiparis.data.entity.Foods;
import com.example.yemeksiparis.databinding.FragmentDetailBinding;
import com.example.yemeksiparis.databinding.FragmentFoodBinding;
import com.example.yemeksiparis.ui.viewmodel.DetailViewModel;
import com.squareup.picasso.Picasso;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class DetailFragment extends Fragment {

    private FragmentDetailBinding binding;
    private DetailViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        binding.setDetailToolbarBaslik("Yemek Detayı");

        DetailFragmentArgs bundle = DetailFragmentArgs.fromBundle(getArguments());
        Foods gelenFood = bundle.getFood();
        binding.setFoodNesnesi(gelenFood);

        Picasso.get().load("http://kasimadalan.pe.hu/yemekler/resimler/" + gelenFood.getYemek_resim_adi()).into(binding.imageView);

        binding.fab.setOnClickListener(view -> {
            Navigation.findNavController(view).navigate(R.id.basketGecis);
        });

        binding.buttonSepeteEkle.setOnClickListener(view -> {
            String siparis = binding.editTextSiparisAdet.getText().toString();
            sepeteEkle(gelenFood.getYemek_adi(), gelenFood.getYemek_resim_adi(), gelenFood.getYemek_fiyat(), 1);
            Toast.makeText(getContext(), siparis + " adet " + gelenFood.getYemek_adi() + " sepete eklendi.", Toast.LENGTH_SHORT).show();
        });


        binding.setDetailFragment(this);
        return binding.getRoot();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(DetailViewModel.class);
    }

    public void sepeteEkle(String yemek_adi, String yemek_resim_adi, int yemek_fiyat, int yemek_siparis_adet) {
        viewModel.sepeteEkle(yemek_adi, yemek_resim_adi, yemek_fiyat, yemek_siparis_adet, KULLANICI_ADI);
    }
}