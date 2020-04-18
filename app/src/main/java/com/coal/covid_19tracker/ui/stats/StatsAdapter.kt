package com.coal.covid_19tracker.ui.stats

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.coal.covid_19tracker.R
import com.coal.covid_19tracker.dataLayer.model.stats.RegionalItem
import com.coal.covid_19tracker.utilities.alerts.Dialog
import com.google.android.material.textview.MaterialTextView
import com.hendraanggrian.recyclerview.widget.ExpandableItem
import com.hendraanggrian.recyclerview.widget.ExpandableRecyclerView
import stream.customalert.CustomAlertDialogue

/**
 * Created by anupam on 27,March,2020
 */

class StatsAdapter(var activity: FragmentActivity?, val stats: List<RegionalItem?>?): RecyclerView.Adapter<StatsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.single_stat_row, parent, false))
    }

    override fun getItemCount() = stats!!.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val region = stats?.get(position)

        val foreign = region?.confirmedCasesForeign
        val indian = region?.confirmedCasesIndian
        var total = indian?.let { foreign?.plus(it) }

        holder.location.text = region?.loc.toString()
        holder.totalCases.text = "Total Cases: ${total}"

        holder.details.setOnClickListener {
            val msg = "Total Deaths : ${region?.deaths} \n Confirmed Cases : ${total} \n Total Discharged : ${region?.discharged}"
             Dialog.showAlert(activity, msg)
        }
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val totalCases =  itemView.findViewById(R.id.total_case) as TextView
        val location = itemView.findViewById(R.id.location) as TextView
        val details = itemView.findViewById(R.id.details) as MaterialTextView
    }



}