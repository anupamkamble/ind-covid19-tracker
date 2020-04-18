package com.coal.covid_19tracker.ui.contact

import androidx.lifecycle.MutableLiveData
import com.coal.covid_19tracker.dataLayer.model.contacts.Contacts
import com.coal.covid_19tracker.dataLayer.model.hospitals.Hospitals
import com.coal.covid_19tracker.dataLayer.repository.CentralRepo
import com.coal.covid_19tracker.ui.baseClasses.BaseViewModel
import com.coal.covid_19tracker.utilities.RX.SchedulerProvider
import com.coal.covid_19tracker.utilities.network.NetworkHelper
import com.coal.covid_19tracker.utilities.viewStates.ViewStates
import io.reactivex.disposables.CompositeDisposable

/**
 * Created by anupam on 26,March,2020
 */


class ContactViewModel (schedulerProvider: SchedulerProvider,
                        val compositeDisposable: CompositeDisposable,
                        networkHelper: NetworkHelper,
                       val repo: CentralRepo
) : BaseViewModel(schedulerProvider,compositeDisposable,networkHelper){
    override fun onCreate() {
    }

    var contactsLiveData = MutableLiveData<ViewStates<Contacts>>()

    fun getContacts(){
        compositeDisposable.add(
            repo.getContacts()
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.ui())
                .subscribe ({
                    contactsLiveData.postValue(ViewStates.success(it))
                },{
                    handleNetworkError(it)
                })
        )
    }
}