package com.coal.covid_19tracker.utilities.viewStates

import com.coal.covid_19tracker.dataLayer.model.hospitals.Hospitals
import com.coal.covid_19tracker.dataLayer.model.notifications.Data

/**
 * Created by anupam on 26,March,2020
 */

data class  ViewStates <out T >constructor(val status: Status,val data:T?) {

    companion object {
        fun <T> success(data: T? = null): ViewStates<T> = ViewStates(Status.SUCCESS, data)

        fun <T> error(data: T? = null): ViewStates<T> = ViewStates(Status.ERROR, data)

        fun <T> loading(data: T? = null): ViewStates<T> = ViewStates(Status.LOADING, data)

        fun <T> unknown(data: T? = null): ViewStates<T> = ViewStates(Status.UNKNOWN, data)
    }
}