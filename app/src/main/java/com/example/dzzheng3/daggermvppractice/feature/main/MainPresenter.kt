package com.example.dzzheng3.daggermvppractice.feature.main

import com.example.dzzheng3.daggermvppractice.data.DataManager
import com.example.dzzheng3.daggermvppractice.di.scope.ConfigPersistent
import com.example.dzzheng3.daggermvppractice.feature.base.BasePresenter
import com.example.dzzheng3.daggermvppractice.util.rx.scheduler.SchedulerUtils
import javax.inject.Inject

@ConfigPersistent
class MainPresenter @Inject
constructor(private val mDataManager: DataManager) : BasePresenter<MainMvpView>() {

    override fun attachView(mvpView: MainMvpView) {
        super.attachView(mvpView)
    }

    fun getPokemon(limit: Int) {
        checkViewAttached()
        mvpView?.showProgress(true)
        mDataManager.getPokemonList(limit)
                .compose(SchedulerUtils.ioToMain<List<String>>())
                .subscribe({ pokemons ->
                    mvpView?.showProgress(false)
                    mvpView?.showPokemon(pokemons)
                }) { throwable ->
                    mvpView?.showProgress(false)
                    mvpView?.showError(throwable)
                }
    }

}