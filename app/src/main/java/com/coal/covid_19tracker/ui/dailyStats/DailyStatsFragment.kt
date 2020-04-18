package com.coal.covid_19tracker.ui.dailyStats

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.lifecycle.Observer
import com.coal.covid_19tracker.R
import com.coal.covid_19tracker.di.components.FragmentComponent
import com.coal.covid_19tracker.ui.baseClasses.BaseFragment
import com.coal.covid_19tracker.ui.hospitals.HospitalFragment
import com.coal.covid_19tracker.utilities.logs.AppLogger
import kotlinx.android.synthetic.main.daily_stats_fragment.*

/**
 * Created by anupam on 26,March,2020
 */

class DailyStatsFragment : BaseFragment<DailyStatsViewModel>(){


    companion object{
        val TAG = "DailyStatsFragment"

        fun newInstance(): DailyStatsFragment {
            val args = Bundle()
            val fragment = DailyStatsFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun provideLayoutId() = R.layout.daily_stats_fragment

    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

    override fun setupView(view: View) {
        viewModel.getDailyStats()

//        swipeContainer.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
//            viewModel.getDailyStats()
//        })

        gridView.setOnItemClickListener(object : AdapterView.OnItemClickListener{
            override fun onItemClick(p0: AdapterView<*>?, view: View?, postion: Int, id: Long) {
                Toast.makeText(context,"Clicked on "+postion,Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.dailyStatsLiveData.observe(this, Observer {
//            if (swipeContainer.isRefreshing){
//                swipeContainer.isRefreshing = false
//            }
            gridView.adapter = CalenderBaseAdapter(it?.data?.data, activity)
            AppLogger.e(HospitalFragment.TAG,it.toString())
        })
    }

}