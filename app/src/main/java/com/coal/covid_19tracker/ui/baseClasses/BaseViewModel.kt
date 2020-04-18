package com.coal.covid_19tracker.ui.baseClasses

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.coal.covid_19tracker.R
import com.coal.covid_19tracker.utilities.RX.SchedulerProvider
import com.coal.covid_19tracker.utilities.network.NetworkHelper
import com.coal.covid_19tracker.utilities.viewStates.ViewStates
import io.reactivex.disposables.CompositeDisposable
import javax.net.ssl.HttpsURLConnection

/**
 * Created by anupam on 26,March,2020
 */

abstract class BaseViewModel(
    protected val schedulerProvider:SchedulerProvider,
    protected val composite:CompositeDisposable,
    protected val networkHelper: NetworkHelper) :ViewModel(){

    override fun onCleared() {
        composite.dispose()
        super.onCleared()
    }

    val messageStringId: MutableLiveData<ViewStates<Int>> = MutableLiveData()
    val messageString: MutableLiveData<ViewStates<String>> = MutableLiveData()


     fun checkInternetConnectionWithMessage(): Boolean =
        if (networkHelper.isNetworkConnected()) {
            true
        } else {
            messageStringId.postValue(ViewStates.error(R.string.network_connection_error))
            false
        }

    protected fun checkInternetConnection(): Boolean = networkHelper.isNetworkConnected()

    protected fun handleNetworkError(err: Throwable?) =
        err?.let {
            networkHelper.castToNetworkError(it).run {
                when (status) {
                    -1 -> messageStringId.postValue(ViewStates.error(R.string.network_default_error))
                    0 -> messageStringId.postValue(ViewStates.error(R.string.server_connection_error))
                    HttpsURLConnection.HTTP_UNAUTHORIZED -> {

                        messageStringId.postValue(ViewStates.error(R.string.permission_denied))
                    }
                    HttpsURLConnection.HTTP_INTERNAL_ERROR ->
                        messageStringId.postValue(ViewStates.error(R.string.network_internal_error))
                    HttpsURLConnection.HTTP_UNAVAILABLE ->
                        messageStringId.postValue(ViewStates.error(R.string.network_server_not_available))
                    else -> messageString.postValue(ViewStates.error(message))
                }
            }
        }


    abstract fun onCreate()

}