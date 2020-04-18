package com.coal.covid_19tracker.utilities.network

/**
 * Created by anupam on 26,March,2020
 */


interface NetworkHelper {

    fun isNetworkConnected(): Boolean

    fun castToNetworkError(throwable: Throwable): NetworkError
}