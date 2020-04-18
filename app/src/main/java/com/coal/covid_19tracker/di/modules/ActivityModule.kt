package com.coal.covid_19tracker.di.modules

import androidx.lifecycle.ViewModelProviders
import com.coal.covid_19tracker.dataLayer.repository.CentralRepo
import com.coal.covid_19tracker.ui.baseClasses.BaseActivity
import com.coal.covid_19tracker.ui.home.HomeViewModel
import com.coal.covid_19tracker.utilities.RX.SchedulerProvider
import com.coal.covid_19tracker.utilities.common.ViewModelProviderFactory
import com.coal.covid_19tracker.utilities.network.NetworkHelper
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by anupam on 26,March,2020
 */


@Module
class ActivityModule(private val activity: BaseActivity<*>) {

    @Provides
    fun provideHomeViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        repo: CentralRepo
    ): HomeViewModel = ViewModelProviders.of(
        activity, ViewModelProviderFactory(HomeViewModel::class) {
            HomeViewModel(schedulerProvider, compositeDisposable, networkHelper, repo)
            //this lambda creates and return HomeViewModel
        }).get(HomeViewModel::class.java)

}