package com.smu.koinmozspace

import android.app.Application
import com.smu.koinmozspace.koin.appComponent
import org.koin.android.ext.android.startKoin

/**
 * Created by sapuser on 2/17/2019.
 */
class MainApp: Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin(this, appComponent)

    }
}