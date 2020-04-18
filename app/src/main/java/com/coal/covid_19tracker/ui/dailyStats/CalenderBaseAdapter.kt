package com.coal.covid_19tracker.ui.dailyStats

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import androidx.fragment.app.FragmentActivity
import com.coal.covid_19tracker.R
import com.coal.covid_19tracker.dataLayer.model.dailyStats.DataItem
import com.google.android.material.textview.MaterialTextView


/**
 * Created by anupam on 29,March,2020
 */

class CalenderBaseAdapter(val calenderList: List<DataItem?>?, activity: FragmentActivity?) : BaseAdapter(){
     var  layoutinflater: LayoutInflater
    init {
        layoutinflater = activity?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {

        val listViewHolder: ViewHolder
        var customView = convertView
        if (customView == null) {
            listViewHolder = ViewHolder()
            customView = layoutinflater.inflate(R.layout.calender_single_row, parent, false)

            listViewHolder.day = customView.findViewById(R.id.day) as MaterialTextView
            listViewHolder.death = customView.findViewById(R.id.death) as MaterialTextView
            listViewHolder.total = customView.findViewById(R.id.tatal) as MaterialTextView
            listViewHolder.discharged = customView.findViewById(R.id.discharged) as MaterialTextView
            customView.setTag(listViewHolder)


        } else {
            listViewHolder = convertView?.getTag() as ViewHolder
        }

        val daysInfo = calenderList?.get(position)

        listViewHolder.day.text = daysInfo?.day.toString()
        listViewHolder.total.text = daysInfo?.summary?.total.toString()
        listViewHolder.death.text = daysInfo?.summary?.deaths.toString()
        listViewHolder.discharged.text = daysInfo?.summary?.discharged.toString()
        return customView
    }

    override fun getItem(position: Int): Any {
        return  position
    }

    override fun getItemId(position: Int): Long {
        return  position.toLong()
    }

    override fun getCount() = calenderList?.size!!

    class ViewHolder(){
        lateinit var day : MaterialTextView
        lateinit var death : MaterialTextView
        lateinit var discharged : MaterialTextView
        lateinit var total : MaterialTextView
    }
}