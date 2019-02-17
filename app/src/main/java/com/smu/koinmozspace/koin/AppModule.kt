package com.smu.koinmozspace.koin

import com.google.gson.Gson
import com.smu.koinmozspace.presentation.activity.MainPresenter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

/**
 * Created by sapuser on 2/17/2019.
 */
val appModule =  module{
    single { Gson() }
    factory { MainPresenter(androidContext(), get() ) }
}

