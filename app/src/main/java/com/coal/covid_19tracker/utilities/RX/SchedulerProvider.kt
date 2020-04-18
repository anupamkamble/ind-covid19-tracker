package com.coal.covid_19tracker.utilities.RX

import io.reactivex.Scheduler
import javax.inject.Singleton

/**
 * Created by anupam on 26,March,2020
 */


@Singleton
interface SchedulerProvider {

    fun computation(): Scheduler

    fun io(): Scheduler

    fun ui(): Scheduler
}