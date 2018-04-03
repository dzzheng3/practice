package com.example.dzzheng3.daggermvppractice.di.component

import com.example.dzzheng3.daggermvppractice.di.module.ActivityModule
import com.example.dzzheng3.daggermvppractice.di.scope.ConfigPersistent
import dagger.Component

@ConfigPersistent
@Component(dependencies = arrayOf(AppComponent::class))
interface ConfigPersistentComponent {
    fun activityComponent(activityModule: ActivityModule): ActivityComponent
}