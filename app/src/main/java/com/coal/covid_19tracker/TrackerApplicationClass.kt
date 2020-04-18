package com.coal.covid_19tracker

import android.app.Application
import com.coal.covid_19tracker.di.components.ApplicationComponent
import com.coal.covid_19tracker.di.components.DaggerApplicationComponent
import com.coal.covid_19tracker.di.modules.ApplicationModule

/**
 * Created by anupam on 26,March,2020
 */

class TrackerApplicationClass : Application(){

    lateinit var  appComponent :ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injecteDependencies()
        appComponent.inject(this)
    }

    fun injecteDependencies(){
        appComponent = DaggerApplicationComponent.builder().applicationModule(ApplicationModule(this)).build()
    }

    fun setComponent(component: ApplicationComponent){
        this.appComponent = component
    }
}