package com.example.dzzheng3.daggermvppractice.di.module

import android.app.Activity
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(var activity: Activity) {
    @Provides
    fun provideContext(): Activity {
        return activity
    }
}