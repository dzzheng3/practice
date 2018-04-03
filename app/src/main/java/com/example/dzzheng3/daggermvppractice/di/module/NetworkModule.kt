package com.example.dzzheng3.daggermvppractice.di.module

import android.content.Context
import com.example.dzzheng3.daggermvppractice.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.readystatesoftware.chuck.ChuckInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule(var context: Context) {
    @Singleton
    @Provides
    fun providesGson(): Gson {
        return GsonBuilder().create()
    }

    @Singleton
    @Provides
    fun provideChuckInterceptor(): ChuckInterceptor {
        return ChuckInterceptor(context)
    }

    @Singleton
    @Provides
    fun provideOkhttpClient(chuckInterceptor: ChuckInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(chuckInterceptor)
                .build()
    }

    @Singleton
    @Provides

    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.POKEAPI_API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }
}