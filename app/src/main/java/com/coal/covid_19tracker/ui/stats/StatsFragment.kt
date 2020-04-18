package com.coal.covid_19tracker.ui.stats

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.coal.covid_19tracker.R
import com.coal.covid_19tracker.di.components.FragmentComponent
import com.coal.covid_19tracker.ui.baseClasses.BaseFragment
import com.coal.covid_19tracker.utilities.logs.AppLogger
import kotlinx.android.synthetic.main.stats_fragment_layout.*

/**
 * Created by anupam on 26,March,2020
 */

class StatsFragment : BaseFragment<StatsViewModel>(){

    companion object{
        val TAG = "StatsFragment"
        fun newInstance(): StatsFragment {
            val args = Bundle()
            val fragment = StatsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun provideLayoutId() = R.layout.stats_fragment_layout
    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

    override fun setupView(view: View) {

        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)


        if (viewModelStore!=null)
        viewModel.getStats()

        swipeContainer.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            viewModel.getStats()
        })
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.statsMutableLiveData.observe(this, Observer {

            if (swipeContainer.isRefreshing){
                swipeContainer.isRefreshing = false
            }

            recyclerView.adapter = StatsAdapter(activity,it.data!!.data!!.regional)

            AppLogger.e(TAG,it.toString())
            it.data!!.data!!.summary!!.apply {
                totalCount.text = this.total.toString()
                dischargeCount.text = this.discharged.toString()
                deathCount.text = this.deaths.toString()
                foreignerIndCount.text = this.confirmedCasesForeign.toString() +" + "+this.confirmedCasesIndian
                lastupdated.text = "last Updated : ${it.data!!.lastRefreshed}"
            }

        })
    }
}