package com.coal.covid_19tracker.di.modules

import com.coal.covid_19tracker.TrackerApplicationClass
import com.coal.covid_19tracker.dataLayer.Network.Endpoints
import com.coal.covid_19tracker.dataLayer.Network.NetworkClient
import com.coal.covid_19tracker.di.scopes.ActivityScope
import com.coal.covid_19tracker.utilities.RX.RxSchedulerProvider
import com.coal.covid_19tracker.utilities.RX.SchedulerProvider
import com.coal.covid_19tracker.utilities.network.NetworkHelper
import com.coal.covid_19tracker.utilities.network.NetworkHelperImpl
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * Created by anupam on 26,March,2020
 */

@Module
class ApplicationModule(val application : TrackerApplicationClass) {

    @Provides
    @Singleton
    fun provideNetworkService() = NetworkClient.createNetWorkClient(Endpoints.BASE_URL,application.cacheDir, 1024*1024*10)

    @Provides
    @Singleton
    fun provideApplication() = application

    @Provides
    fun provideCompositeDisposable() = CompositeDisposable()


    @Provides
    fun provideSchedulerProvider(): SchedulerProvider = RxSchedulerProvider()

    @Provides
    @Singleton
    fun provideNetworkHelper(): NetworkHelper = NetworkHelperImpl(application)
}