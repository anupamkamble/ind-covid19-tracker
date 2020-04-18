package com.coal.covid_19tracker.ui.stats

import androidx.lifecycle.MutableLiveData
import com.coal.covid_19tracker.dataLayer.model.stats.Stats
import com.coal.covid_19tracker.dataLayer.repository.CentralRepo
import com.coal.covid_19tracker.ui.baseClasses.BaseViewModel
import com.coal.covid_19tracker.ui.dailyStats.DailyStatsViewModel
import com.coal.covid_19tracker.utilities.RX.SchedulerProvider
import com.coal.covid_19tracker.utilities.logs.AppLogger
import com.coal.covid_19tracker.utilities.network.NetworkHelper
import com.coal.covid_19tracker.utilities.viewStates.ViewStates
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by anupam on 26,March,2020
 */


class StatsViewModel(schedulerProvider: SchedulerProvider,
                     val compositeDisposable: CompositeDisposable,
                     networkHelper: NetworkHelper,
                     val repo: CentralRepo
) : BaseViewModel(schedulerProvider,compositeDisposable,networkHelper){

    companion object{
        val TAG = "StatsViewModel"
    }
    override fun onCreate() {
    }

    var statsMutableLiveData = MutableLiveData<ViewStates<Stats>>()

    fun getStats(){
        compositeDisposable.add(
            repo.getLatestStats()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe ({
                    statsMutableLiveData.postValue(ViewStates.success(it))

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