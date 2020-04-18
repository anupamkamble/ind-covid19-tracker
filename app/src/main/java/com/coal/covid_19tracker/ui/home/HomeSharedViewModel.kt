package com.coal.covid_19tracker.ui.home

import androidx.lifecycle.MutableLiveData
import com.coal.covid_19tracker.ui.baseClasses.BaseViewModel
import com.coal.covid_19tracker.utilities.RX.SchedulerProvider
import com.coal.covid_19tracker.utilities.network.NetworkHelper
import com.coal.covid_19tracker.utilities.viewStates.Event
import com.coal.covid_19tracker.utilities.viewStates.Status
import io.reactivex.disposables.CompositeDisposable

class HomeSharedViewModel(
    schedulerProvider: SchedulerProvider,
    compositeDisposable: CompositeDisposable,
    networkHelper: NetworkHelper
) : BaseViewModel(schedulerProvider, compositeDisposable, networkHelper) {

    override fun onCreate() {}

    val homeRedirection = MutableLiveData<Event<Boolean>>()

    val newPost: MutableLiveData<Event<Status>> = MutableLiveData()

    fun onHomeRedirect() {
        homeRedirection.postValue(Event(true))
    }
}