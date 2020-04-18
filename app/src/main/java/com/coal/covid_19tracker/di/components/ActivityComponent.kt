package com.coal.covid_19tracker.di.components

import com.coal.covid_19tracker.di.modules.ActivityModule
import com.coal.covid_19tracker.di.scopes.ActivityScope
import com.coal.covid_19tracker.ui.home.HomeActivity
import dagger.Component

/**
 * Created by anupam on 26,March,2020
 */
@ActivityScope
@Component(modules = [ActivityModule::class],
    dependencies = [ApplicationComponent::class])
interface ActivityComponent {
    fun inject(activity:HomeActivity)

}