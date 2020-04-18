package com.coal.covid_19tracker.utilities.logs

import timber.log.Timber

/**
 * Created by anupam on 26,March,2020
 */

object AppLogger {

    var enabled = true
    private set

    init { if (enabled) Timber.plant(Timber.DebugTree()) }

    fun e(TAG:String, msg:String) {Timber.tag(TAG).e(msg)}
    fun d(TAG:String, msg:String) {Timber.tag(TAG).d(msg)}
    fun v(TAG:String, msg:String) {Timber.tag(TAG).v(msg)}
    fun i(TAG:String, msg:String) {Timber.tag(TAG).i(msg)}

}