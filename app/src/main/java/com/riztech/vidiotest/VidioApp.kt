package com.riztech.vidiotest

import android.app.Application
import com.riztech.vidiotest.di.component.DaggerAppComponent

class VidioApp: Application() {
    val appComponent by lazy {
        DaggerAppComponent.factory().context(this)
    }
}