package com.example.dzzheng3.daggermvppractice.feature.main

import com.example.dzzheng3.daggermvppractice.feature.base.MvpView

interface MainMvpView : MvpView {

    fun showPokemon(pokemon: List<String>)

    fun showProgress(show: Boolean)

    fun showError(error: Throwable)

}