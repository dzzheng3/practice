package com.example.dzzheng3.daggermvppractice.util.rx.scheduler

import com.example.dzzheng3.daggermvppractice.util.rx.scheduler.BaseScheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by lam on 2/6/17.
 */

class SingleMainScheduler<T> protected constructor() : BaseScheduler<T>(Schedulers.single(), AndroidSchedulers.mainThread())
