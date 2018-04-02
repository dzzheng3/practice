package com.example.dzzheng3.daggermvppractice.feature.base

interface Presenter<V : MvpView> {
    fun attachView(mvpView: V)
    fun detachView()
}