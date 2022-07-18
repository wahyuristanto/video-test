package com.riztech.vidiotest.di.component

import android.app.Application
import com.riztech.vidiotest.di.module.CoreNetworkModule
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [CoreNetworkModule::class])
interface AppComponent {
    fun getSearchComponent(): SearchSubComponent
    fun getCategoryComponent(): CategorySubComponent
    fun getCategoryDetailComponent(): CategoryDetailSubComponent


    @Component.Factory
    interface Factory{
        fun context(@BindsInstance application: Application): AppComponent
    }
}