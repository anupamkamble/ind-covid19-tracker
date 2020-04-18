package com.coal.covid_19tracker.ui.home

import androidx.lifecycle.MutableLiveData
import com.coal.covid_19tracker.dataLayer.repository.CentralRepo
import com.coal.covid_19tracker.ui.baseClasses.BaseViewModel
import com.coal.covid_19tracker.utilities.RX.SchedulerProvider
import com.coal.covid_19tracker.utilities.network.NetworkHelper
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by anupam on 26,March,2020
 */

class HomeViewModel( schedulerProvider: SchedulerProvider,
                     composite: CompositeDisposable,
                     networkHelper: NetworkHelper,
                     repo: CentralRepo
) : BaseViewModel(schedulerProvider,composite,networkHelper){

    val statsNavigation = MutableLiveData<Boolean>()
    val dailyStatsNavigation = MutableLiveData<Boolean>()
    val hospitalNavigation = MutableLiveData<Boolean>()
    val contactNavigation = MutableLiveData<Boolean>()

    override fun onCreate() {
        statsNavigation.postValue(true)
    }

    fun onStatsSelected(){
        statsNavigation.postValue(true)
    }

    fun onDailyStatsSelected(){
        dailyStatsNavigation.postValue(true)

    }
    fun onHospitalSelected(){
        hospitalNavigation.postValue(true)
    }

    fun onContactSelected(){
        contactNavigation.postValue(true)
    }
}
