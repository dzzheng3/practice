package com.example.dzzheng3.daggermvppractice.di.module

import android.app.Application
import dagger.Module
import dagger.Provides

@Module(includes = arrayOf(PokemanApiModule::class))
class AppModule(var application: Application) {
    @Provides
    fun provideContext(): Application {
        return application
    }
}