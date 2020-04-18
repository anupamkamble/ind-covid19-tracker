package com.coal.covid_19tracker.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.coal.covid_19tracker.R
import com.coal.covid_19tracker.di.components.ActivityComponent
import com.coal.covid_19tracker.ui.baseClasses.BaseActivity
import com.coal.covid_19tracker.ui.contact.ContactFragment
import com.coal.covid_19tracker.ui.dailyStats.DailyStatsFragment
import com.coal.covid_19tracker.ui.hospitals.HospitalFragment
import com.coal.covid_19tracker.ui.stats.StatsFragment
import kotlinx.android.synthetic.main.activity_home.*

/**
 * Created by anupam on 26,March,2020
 */

class HomeActivity : BaseActivity<HomeViewModel>(){

    private var activeFragment: Fragment? = null

    override fun provideResourceId() = R.layout.activity_home
    override fun injectDependencies(activityComponent: ActivityComponent) = activityComponent.inject(this)

    override fun setupObservers() {
        super.setupObservers()

        viewModel.statsNavigation.observe(this, Observer {
            showStats()
        })
        viewModel.dailyStatsNavigation.observe(this, Observer {
            showDailyStats()
        })
        viewModel.contactNavigation.observe(this, Observer {
            showContacts()
        })

        viewModel.hospitalNavigation.observe(this, Observer {
            showHospitals()
        })
    }

    override fun setupView(savedInstanceState: Bundle?) {

        bottomNavigation.run {
            itemIconTintList = null

            setOnNavigationItemSelectedListener {
                when(it.itemId){
                    R.id.itemStats -> {
                        viewModel.onStatsSelected()
                        true
                    }
                    R.id.itemDailyStats -> {
                        viewModel.onDailyStatsSelected()
                        true
                    }
                    R.id.itemHospital -> {
                        viewModel.onHospitalSelected()
                        true
                    }
                    R.id.itemContact -> {
                        viewModel.onContactSelected()
                        true
                    }else  -> false
                }
            }
        }
    }

    fun showStats(){

        if(activeFragment is StatsFragment) return
        val fragmentTransactions = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(StatsFragment.TAG) as StatsFragment?
        if(fragment == null){
            fragment = StatsFragment.newInstance()
            fragmentTransactions.add(R.id.containerFragment, fragment,StatsFragment.TAG)
        }else{
            fragmentTransactions.show(fragment)
        }
        if(activeFragment!=null) fragmentTransactions.hide(activeFragment as Fragment)
        fragmentTransactions.commit()
        activeFragment = fragment
    }


    fun showContacts(){

        if(activeFragment is ContactFragment) return
        val fragmentTransactions = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(ContactFragment.TAG) as ContactFragment?
        if(fragment == null){
            fragment = ContactFragment.newInstance()
            fragmentTransactions.add(R.id.containerFragment, fragment,ContactFragment.TAG)
        }else{
            fragmentTransactions.show(fragment)
        }
        if(activeFragment!=null) fragmentTransactions.hide(activeFragment as Fragment)
        fragmentTransactions.commit()
        activeFragment = fragment

    }

    fun showDailyStats(){
        if(activeFragment is DailyStatsFragment) return
        val fragmentTransactions = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(DailyStatsFragment.TAG) as DailyStatsFragment?
        if(fragment == null){
            fragment = DailyStatsFragment.newInstance()
            fragmentTransactions.add(R.id.containerFragment, fragment,DailyStatsFragment.TAG)
        }else{
            fragmentTransactions.show(fragment)
        }
        if(activeFragment!=null) fragmentTransactions.hide(activeFragment as Fragment)
        fragmentTransactions.commit()
        activeFragment = fragment

    }
    fun showHospitals(){
        if(activeFragment is HospitalFragment) return

        val fragmentTransactions = supportFragmentManager.beginTransaction()
        var fragment = supportFragmentManager.findFragmentByTag(HospitalFragment.TAG) as HospitalFragment?
        if(fragment == null){
            fragment = HospitalFragment.newInstance()
            fragmentTransactions.add(R.id.containerFragment, fragment,HospitalFragment.TAG)
        }else{
            fragmentTransactions.show(fragment)
        }
        if(activeFragment!=null) fragmentTransactions.hide(activeFragment as Fragment)
        fragmentTransactions.commit()
        activeFragment = fragment

    }
}