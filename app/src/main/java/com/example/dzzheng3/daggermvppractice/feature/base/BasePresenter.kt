package com.example.dzzheng3.daggermvppractice.feature.base

open class BasePresenter<T : MvpView> : Presenter<T> {
    var mvpView: T? = null
    override fun attachView(mvpView: T) {
        this.mvpView = mvpView
    }

    override fun detachView() {
        mvpView = null
    }

}