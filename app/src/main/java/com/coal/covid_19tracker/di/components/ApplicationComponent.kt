package com.coal.covid_19tracker.di.components

import com.coal.covid_19tracker.TrackerApplicationClass
import com.coal.covid_19tracker.dataLayer.Network.NetworkService
import com.coal.covid_19tracker.dataLayer.repository.CentralRepo
import com.coal.covid_19tracker.di.modules.ApplicationModule
import com.coal.covid_19tracker.utilities.RX.RxSchedulerProvider
import com.coal.covid_19tracker.utilities.RX.SchedulerProvider
import com.coal.covid_19tracker.utilities.network.NetworkHelper
import dagger.Component
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by anupam on 26,March,2020
 */

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {
    fun inject(application: TrackerApplicationClass)

    fun getNetWorkService(): NetworkService
    fun getCompositeDisposable(): CompositeDisposable
    fun getSchedulerProvider(): SchedulerProvider
    fun getNetworkHelper(): NetworkHelper
    fun getRepository(): CentralRepo

}