package com.example.dzzheng3.daggermvppractice.feature.main

import android.os.Bundle
import com.example.dzzheng3.daggermvppractice.R
import com.example.dzzheng3.daggermvppractice.feature.base.BaseActivity

class MainActivity : BaseActivity() {
    override val layout: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityComponent().inject(this)
    }
}
