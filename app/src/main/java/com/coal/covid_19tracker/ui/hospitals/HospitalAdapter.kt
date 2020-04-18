package com.coal.covid_19tracker.ui.hospitals

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.coal.covid_19tracker.R
import com.coal.covid_19tracker.dataLayer.model.hospitals.RegionalItem
import com.coal.covid_19tracker.utilities.alerts.Dialog
import com.google.android.material.textview.MaterialTextView

/**
 * Created by anupam on 29,March,2020
 */

class HospitalAdapter(val activity: FragmentActivity?, val hospitals: List<RegionalItem?>?) : RecyclerView.Adapter<HospitalAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HospitalAdapter.ViewHolder {
        return HospitalAdapter.ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.hospital_row, parent, false))
    }

    override fun getItemCount(): Int = hospitals?.size!!

    override fun onBindViewHolder(holder: HospitalAdapter.ViewHolder, position: Int) {

        val hospitals = hospitals?.get(position)

        val ruralHospital = hospitals?.ruralHospitals
        val urbanHos = hospitals?.urbanHospitals

        var totalHos = ruralHospital?.let { urbanHos?.plus(it) }

        val ruralBeds = hospitals?.ruralBeds
        val urbanBeds = hospitals?.urbanBeds

        var totalBeds = ruralBeds?.let { urbanBeds?.plus(it) }

        holder.location.text = hospitals?.state

        holder.totalHospitals.text = "Total Hospitals: ${totalHos}"
        holder.totalBeds.text = "Total Beds: ${totalBeds}"

        holder.details.setOnClickListener {

            val msg =  "Urban Hospitals/Beds : ${hospitals?.urbanHospitals}/${hospitals?.urbanBeds}\n" +
                       "Rural Hospitals/Beds : ${hospitals?.ruralHospitals}/${hospitals?.ruralBeds}\n "

            Dialog.showAlert(activity, msg)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val totalHospitals =  itemView.findViewById(R.id.total_hospitals) as MaterialTextView
        val location = itemView.findViewById(R.id.location) as MaterialTextView
        val totalBeds = itemView.findViewById(R.id.total_beds) as MaterialTextView
        val details = itemView.findViewById(R.id.details) as MaterialTextView
    }
}