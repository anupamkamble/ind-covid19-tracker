package com.coal.covid_19tracker.ui.dailyStats

import androidx.lifecycle.MutableLiveData
import com.coal.covid_19tracker.dataLayer.model.dailyStats.DailyStats
import com.coal.covid_19tracker.dataLayer.model.hospitals.Hospitals
import com.coal.covid_19tracker.dataLayer.repository.CentralRepo
import com.coal.covid_19tracker.ui.baseClasses.BaseViewModel
import com.coal.covid_19tracker.utilities.RX.SchedulerProvider
import com.coal.covid_19tracker.utilities.logs.AppLogger
import com.coal.covid_19tracker.utilities.network.NetworkHelper
import com.coal.covid_19tracker.utilities.viewStates.ViewStates
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by anupam on 26,March,2020
 */

class DailyStatsViewModel(schedulerProvider: SchedulerProvider,
                          val compositeDisposable: CompositeDisposable,
                          networkHelper: NetworkHelper,
                          val repo: CentralRepo
) : BaseViewModel(schedulerProvider,compositeDisposable,networkHelper){
    override fun onCreate() {
    }

    companion object {
        val TAG = "DailyStatsViewModel"
    }


    var dailyStatsLiveData = MutableLiveData<ViewStates<DailyStats>>()

    fun getDailyStats(){
        compositeDisposable.add(
            repo.getDailyStats()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe ({
                    dailyStatsLiveData.postValue(ViewStates.success(it))
                },{
                    handleNetworkError(it)
                })
        )
    }

    override fun onCleared() {
        super.onCleared()
        AppLogger.e(TAG, "onClearedc Clled")
    }
}