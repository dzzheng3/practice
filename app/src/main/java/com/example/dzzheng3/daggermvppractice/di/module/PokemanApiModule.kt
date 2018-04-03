package com.example.dzzheng3.daggermvppractice.di.module

import com.example.dzzheng3.daggermvppractice.data.remote.PokemonApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = arrayOf(NetworkModule::class))
class PokemanApiModule {
    @Singleton
    @Provides
    fun providePokemonApi(retrofit: Retrofit): PokemonApi {
        return retrofit.create(PokemonApi::class.java)
    }
}