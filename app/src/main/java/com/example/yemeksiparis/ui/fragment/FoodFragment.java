package com.example.yemeksiparis.ui.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.core.view.MenuProvider;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.yemeksiparis.R;
import com.example.yemeksiparis.data.entity.Foods;
import com.example.yemeksiparis.databinding.FragmentFoodBinding;
import com.example.yemeksiparis.ui.adapter.FoodsAdapter;
import com.example.yemeksiparis.ui.viewmodel.DetailViewModel;
import com.example.yemeksiparis.ui.viewmodel.FoodViewModel;

import java.util.ArrayList;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class FoodFragment extends Fragment {
    private FragmentFoodBinding binding;
    private FoodViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_food, container, false);

        binding.setFoodToolbarBaslik("Yemek Listesi");
        ((AppCompatActivity) getActivity()).setSupportActionBar(binding.toolbarFood);

        viewModel.foodList.observe(getViewLifecycleOwner(),foodArrayList ->{
            FoodsAdapter adapter = new FoodsAdapter(requireContext(),foodArrayList,viewModel);
            binding.setFoodAdapter(adapter);
        });

        binding.setFoodFragment(this);

        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.toolbar_menu,menu);

             }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {
                return false;
            }
        },getViewLifecycleOwner(), Lifecycle.State.RESUMED);

        return binding.getRoot();
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(FoodViewModel.class);
    }



}