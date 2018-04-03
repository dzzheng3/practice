package com.example.dzzheng3.daggermvppractice.di.component

import com.example.dzzheng3.daggermvppractice.data.DataManager
import com.example.dzzheng3.daggermvppractice.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent{
    fun dataManager(): DataManager
}