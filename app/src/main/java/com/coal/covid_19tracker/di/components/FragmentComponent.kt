package com.coal.covid_19tracker.di.components

import com.coal.covid_19tracker.di.modules.FragmentModule
import com.coal.covid_19tracker.di.scopes.FragmentScope
import com.coal.covid_19tracker.ui.contact.ContactFragment
import com.coal.covid_19tracker.ui.dailyStats.DailyStatsFragment
import com.coal.covid_19tracker.ui.hospitals.HospitalFragment
import com.coal.covid_19tracker.ui.stats.StatsFragment
import dagger.Component

/**
 * Created by anupam on 26,March,2020
 */

@FragmentScope
@Component(modules = [FragmentModule::class], dependencies = [ApplicationComponent::class])
interface FragmentComponent {

    fun inject(fragment: ContactFragment)
    fun inject(fragment: DailyStatsFragment)
    fun inject(fragment: HospitalFragment)
    fun inject(fragment: StatsFragment)

}