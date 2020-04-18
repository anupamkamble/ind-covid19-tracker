package com.coal.covid_19tracker.ui.contact

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
import kotlinx.android.synthetic.main.contact_fragment_layout.*
import kotlinx.android.synthetic.main.stats_fragment_layout.recyclerView
import kotlinx.android.synthetic.main.stats_fragment_layout.swipeContainer

/**
 * Created by anupam on 26,March,2020
 */

class ContactFragment : BaseFragment<ContactViewModel>(){

    companion object{
        val TAG = "ContactFragment"

        fun newInstance(): ContactFragment {
            val args = Bundle()
            val fragment = ContactFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun provideLayoutId() = R.layout.contact_fragment_layout
    override fun injectDependencies(fragmentComponent: FragmentComponent) = fragmentComponent.inject(this)

    override fun setupView(view: View) {
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.setHasFixedSize(true)
        viewModel.getContacts()
        swipeContainer.setOnRefreshListener(SwipeRefreshLayout.OnRefreshListener {
            viewModel.getContacts()
        })
    }

    override fun setupObservers() {
        super.setupObservers()
        viewModel.contactsLiveData.observe(this, Observer {

            if (swipeContainer.isRefreshing){
                swipeContainer.isRefreshing = false
            }

            recyclerView.adapter = ContactAdapter(activity,it.data!!.data!!.contacts!!.regional)

            AppLogger.e(StatsFragment.TAG,it.toString())
            it.data!!.data!!.contacts!!.primary?.apply {

                number_val.text = this.number.toString()
                tollNo.text = this.numberTollfree.toString()
                emailVal.text = this.email.toString()
                emailVal.text = this.email.toString()
                twitterVal.text = this.twitter.toString()
                facebookVal.text = this.facebook.toString()
            }
        })
    }
}