package com.coal.covid_19tracker.ui.hospitals

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.coal.covid_19tracker.R
import com.coal.covid_19tracker.di.components.FragmentComponent
import com.coal.covid_19tracker.ui.baseClasses.BaseFragment
import com.coal.covid_19tracker.ui.stats.StatsFragment
import com.coal.covid_19tracker.utilities.logs.AppLogger
import kotlinx.android.synthetic.main.hospital_fragment_layout.*
import kotlinx.android.synthetic.main.stats_fragment_layout.*
import kotlinx.android.synthetic.main.stats_fragment_layout.lastupdated
import kotlinx.android.synthetic.main.stats_fragment_layout.recyclerView
import kotlinx.android.synthetic.main.stats_fragment_layout.swipeContainer

/**
 * Created by anupam on 26,March,2020
 */


class HospitalFragment : BaseFragment<HospitalViewModel>(){

    companion object{
        val TAG = "HospitalFragment"

        fun newInstance(): HospitalFragment {
            val args = Bundle()
            val fragment = HospitalFragment()
            fragment.arguments = args
            return fragment
        }
    }
    override fun provideLayoutId() = R.layout.hospital_fragment_layout

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

    override fun setupView(view: View) {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        viewModel.getHospitals()
        swipeContainer.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            viewModel.getHospitals()
        })
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.hospitalLiveData.observe(this, Observer {
            if (swipeContainer.isRefreshing){
                swipeContainer.isRefreshing = false
            }
            recyclerView.adapter = HospitalAdapter(activity, it!!.data?.data?.regional)
            AppLogger.e(TAG,it.toString())
            it.data!!.data!!.summary!!.apply {
                totalHos.text = (this.ruralHospitals!!.toInt() + this.urbanHospitals!!.toInt()).toString()
                totalBedCount.text = (this.ruralBeds!!.toInt() + this.urbanBeds!!.toInt()).toString()
                lastupdated.text = "last Updated : ${it.data!!.lastRefreshed}"
            }
        })
    }
}