package com.example.dzzheng3.daggermvppractice

import android.app.Application
import android.content.Context
import com.example.dzzheng3.daggermvppractice.di.component.AppComponent
import com.example.dzzheng3.daggermvppractice.di.component.DaggerAppComponent
import com.example.dzzheng3.daggermvppractice.di.module.AppModule
import com.example.dzzheng3.daggermvppractice.di.module.NetworkModule
import com.singhajit.sherlock.core.Sherlock
import com.squareup.leakcanary.LeakCanary

class MyApp : Application() {
    internal var appComponent: AppComponent? = null
    var component: AppComponent
        get() {
            if (appComponent == null) {
                appComponent = DaggerAppComponent.builder()
                        .appModule(AppModule(this))
                        .networkModule(NetworkModule(this))
                        .build()
            }
            return appComponent as AppComponent
        }
        set(value) {
        }

    companion object {
        operator fun get(context: Context): MyApp {
            return context.applicationContext as MyApp
        }
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            LeakCanary.install(this)
            Sherlock.init(this)
        }
    }
}