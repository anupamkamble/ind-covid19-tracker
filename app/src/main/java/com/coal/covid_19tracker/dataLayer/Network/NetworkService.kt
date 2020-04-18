package com.coal.covid_19tracker.dataLayer.Network

import android.database.Observable
import com.coal.covid_19tracker.dataLayer.model.contacts.Contacts
import com.coal.covid_19tracker.dataLayer.model.dailyStats.DailyStats
import com.coal.covid_19tracker.dataLayer.model.hospitals.Hospitals
import com.coal.covid_19tracker.dataLayer.model.notifications.Notifications
import com.coal.covid_19tracker.dataLayer.model.stats.Stats
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by anupam on 26,March,2020
 */


interface NetworkService {

    @GET(Endpoints.GET_STATS)
    fun getStats(): Single<Stats>

    @GET(Endpoints.GET_DAILY_STATS)
    fun getDailyStats() : Single<DailyStats>

    @GET(Endpoints.GET_HOSPITAL_AND_BEDS)
    fun getHospitals() : Single<Hospitals>

    @GET(Endpoints.GET_CONTACTS)
    fun getContacts() : Single<Contacts>

    @GET(Endpoints.GET_NOTIFICATIONS)
    fun getNotifications() : Observable<Notifications>
}