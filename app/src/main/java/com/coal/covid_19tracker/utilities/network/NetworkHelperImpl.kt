package com.coal.covid_19tracker.utilities.network

import android.content.Context
import android.net.ConnectivityManager
import com.coal.covid_19tracker.utilities.logs.AppLogger
import com.google.gson.GsonBuilder
import com.google.gson.JsonSyntaxException
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException
import java.io.IOException
import java.net.ConnectException

/**
 * Created by anupam on 26,March,2020
 */


class NetworkHelperImpl constructor(private val context: Context) : NetworkHelper {

    companion object {
        private const val TAG = "NetworkHelper"
    }

    override fun isNetworkConnected(): Boolean {
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork?.isConnected ?: false
    }

    override fun castToNetworkError(throwable: Throwable): NetworkError {
        val defaultNetworkError = NetworkError()
        try {
            if (throwable is ConnectException) return NetworkError(0, "0")
            if (throwable !is HttpException) return defaultNetworkError

            val error = GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create()
                .fromJson(throwable.response().errorBody()?.string(), NetworkError::class.java)
            return NetworkError(throwable.code(), error.statusCode, error.message)
        } catch (e: IOException) {
            AppLogger.e(TAG, e.toString())
        } catch (e: JsonSyntaxException) {
            AppLogger.e(TAG, e.toString())
        } catch (e: NullPointerException) {
            AppLogger.e(TAG, e.toString())
        }
        return defaultNetworkError
    }
}