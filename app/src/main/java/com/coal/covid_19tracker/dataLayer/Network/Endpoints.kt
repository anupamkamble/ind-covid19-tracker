package com.coal.covid_19tracker.dataLayer.Network

/**
 * Created by anupam on 26,March,2020
 *
 * Stats: https://api.rootnet.in/covid19-in/stats/latest
Stats as a daily series: https://api.rootnet.in/covid19-in/stats/daily
Hospitals & bed stats: https://api.rootnet.in/covid19-in/stats/hospitals
Contact & helpline: https://api.rootnet.in/covid19-in/contacts
Notifications & advisories: https://api.rootnet.in/covid19-in/notifications
 */


object Endpoints {

    const val BASE_URL = "https://api.rootnet.in"

    const val GET_STATS = "/covid19-in/stats/latest"
    const val GET_DAILY_STATS = "/covid19-in/stats/daily"
    const val GET_HOSPITAL_AND_BEDS = "/covid19-in/stats/hospitals"
    const val GET_CONTACTS = "/covid19-in/contacts"
    const val GET_NOTIFICATIONS = "/covid19-in/notifications"
}