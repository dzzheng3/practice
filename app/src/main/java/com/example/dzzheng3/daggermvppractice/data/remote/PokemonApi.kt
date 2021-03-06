package com.example.dzzheng3.daggermvppractice.data.remote

import com.example.dzzheng3.daggermvppractice.data.model.Pokemon
import com.example.dzzheng3.daggermvppractice.data.model.PokemonListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon")
    fun getPokemonList(@Query("limit") limit: Int): Single<PokemonListResponse>

    @GET("pokemon/{name}")
    fun getPokemon(@Path("name") name: String): Single<Pokemon>
}