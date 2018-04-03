package com.example.dzzheng3.daggermvppractice.feature.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.dzzheng3.daggermvppractice.MyApp
import com.example.dzzheng3.daggermvppractice.di.component.ActivityComponent
import com.example.dzzheng3.daggermvppractice.di.component.DaggerConfigPersistentComponent
import com.example.dzzheng3.daggermvppractice.di.module.ActivityModule

abstract class BaseActivity : AppCompatActivity() {
    private var activityComponent: ActivityComponent? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        val configPersistentComponent = DaggerConfigPersistentComponent.builder().appComponent(MyApp[this].component).build()
        activityComponent = configPersistentComponent.activityComponent(ActivityModule(this))
        activityComponent?.inject(this)
    }

    abstract val layout: Int

    fun activityComponent(): ActivityComponent {
        return activityComponent as ActivityComponent
    }
}