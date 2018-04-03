package com.example.dzzheng3.daggermvppractice.di.component

import com.example.dzzheng3.daggermvppractice.di.module.ActivityModule
import com.example.dzzheng3.daggermvppractice.feature.base.BaseActivity
import com.readystatesoftware.chuck.internal.ui.MainActivity
import dagger.Subcomponent

@Subcomponent(modules = arrayOf(ActivityModule::class))
interface ActivityComponent {
    fun inject(baseActivity: BaseActivity)
    fun inject(mainActivity: MainActivity)
}