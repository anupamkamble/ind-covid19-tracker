package com.coal.covid_19tracker.utilities.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by anupam on 26,March,2020
 */

data class NetworkError(
    val status: Int = -1,
    @Expose
    @SerializedName("statusCode")
    val statusCode: String = "-1",

    @Expose
    @SerializedName("message")
    val message: String = "Something went wrong"
)