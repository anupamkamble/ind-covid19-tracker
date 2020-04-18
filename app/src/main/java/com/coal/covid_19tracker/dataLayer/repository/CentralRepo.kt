package com.coal.covid_19tracker.dataLayer.repository

import com.coal.covid_19tracker.dataLayer.Network.NetworkService
import com.coal.covid_19tracker.dataLayer.model.contacts.Contacts
import com.coal.covid_19tracker.dataLayer.model.dailyStats.DailyStats
import com.coal.covid_19tracker.dataLayer.model.hospitals.Hospitals
import com.coal.covid_19tracker.dataLayer.model.stats.Stats
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by anupam on 26,March,2020
 */

@Singleton
class CentralRepo @Inject constructor(private val networkService: NetworkService) {

    fun getLatestStats(): Single<Stats> {
        return networkService.getStats().map { it }
    }

    fun getHospitals(): Single<Hospitals> {
        return networkService.getHospitals().map { it }
    }

    fun getContacts(): Single<Contacts> {
        return networkService.getContacts().map { it }
    }

    fun getDailyStats(): Single<DailyStats> {
        return networkService.getDailyStats().map { it }
    }
}