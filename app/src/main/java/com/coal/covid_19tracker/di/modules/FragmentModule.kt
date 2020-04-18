package com.coal.covid_19tracker.di.modules

import androidx.lifecycle.ViewModelProviders
import com.coal.covid_19tracker.dataLayer.repository.CentralRepo
import com.coal.covid_19tracker.ui.baseClasses.BaseFragment
import com.coal.covid_19tracker.ui.contact.ContactViewModel
import com.coal.covid_19tracker.ui.dailyStats.DailyStatsViewModel
import com.coal.covid_19tracker.ui.home.HomeViewModel
import com.coal.covid_19tracker.ui.hospitals.HospitalViewModel
import com.coal.covid_19tracker.ui.stats.StatsViewModel
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
class FragmentModule (private val fragment: BaseFragment<*>) {

    @Provides
    fun provideDailyStatsViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        repo: CentralRepo
    ): DailyStatsViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(DailyStatsViewModel::class) {
            DailyStatsViewModel(schedulerProvider, compositeDisposable, networkHelper, repo)

        }).get(DailyStatsViewModel::class.java)

    @Provides
    fun provideStatsViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        repo: CentralRepo
    ): StatsViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(StatsViewModel::class) {
            StatsViewModel(schedulerProvider, compositeDisposable, networkHelper, repo)

        }).get(StatsViewModel::class.java)


    @Provides
    fun provideHospitalViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        repo: CentralRepo
    ): HospitalViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(HospitalViewModel::class) {
            HospitalViewModel(schedulerProvider, compositeDisposable, networkHelper, repo)

        }).get(HospitalViewModel::class.java)


    @Provides
    fun provideContactsViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        repo: CentralRepo
    ): ContactViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(ContactViewModel::class) {
            ContactViewModel(schedulerProvider, compositeDisposable, networkHelper, repo)

        }).get(ContactViewModel::class.java)


    @Provides
    fun provideHomeViewModel(
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        networkHelper: NetworkHelper,
        repo: CentralRepo
    ): HomeViewModel = ViewModelProviders.of(
        fragment, ViewModelProviderFactory(HomeViewModel::class) {
            HomeViewModel(schedulerProvider, compositeDisposable, networkHelper, repo)
            //this lambda creates and return HomeViewModel
        }).get(HomeViewModel::class.java)

}