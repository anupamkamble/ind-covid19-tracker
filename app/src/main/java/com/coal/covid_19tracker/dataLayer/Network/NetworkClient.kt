package com.coal.covid_19tracker.dataLayer.Network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by anupam on 26,March,2020
 */

object NetworkClient {
    val  NETWORK_TIME_OUT = 60


    fun createNetWorkClient(baseURL: String, cacheDir: File, cacheSize:Long):NetworkService{
       return Retrofit.Builder()
            .baseUrl(baseURL)
            .client(
                OkHttpClient.Builder()
                    .cache(Cache(cacheDir,cacheSize))
                    .addInterceptor(HttpLoggingInterceptor().apply {
                        level = if (true) HttpLoggingInterceptor.Level.BODY
                        else HttpLoggingInterceptor.Level.NONE
                    })
                    .readTimeout(NETWORK_TIME_OUT.toLong(),TimeUnit.SECONDS)
                    .writeTimeout(NETWORK_TIME_OUT.toLong(),TimeUnit.SECONDS)
                    .build()
            )
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(NetworkService::class.java)

    }

}