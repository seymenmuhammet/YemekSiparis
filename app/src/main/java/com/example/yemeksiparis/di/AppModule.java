package com.example.yemeksiparis.di;

import com.example.yemeksiparis.data.repo.FoodsDaoRepository;
import com.example.yemeksiparis.retrofit.ApiUtils;
import com.example.yemeksiparis.retrofit.FoodsDao;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class AppModule {
    @Provides
    @Singleton
    public FoodsDaoRepository provideFoodsDaoRepository(FoodsDao fdao){
        return new FoodsDaoRepository(fdao);
    }

    @Provides
    @Singleton
    public FoodsDao provideFoodsDao(){
        return ApiUtils.getFoodsDao();
    }

}
