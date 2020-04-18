package com.coal.covid_19tracker.ui.contact

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.coal.covid_19tracker.R
import com.coal.covid_19tracker.dataLayer.model.contacts.RegionalItem
import com.google.android.material.textview.MaterialTextView

/**
 * Created by anupam on 29,March,2020
 */

class ContactAdapter(val activity: FragmentActivity?, val contacts: List<RegionalItem?>?) : RecyclerView.Adapter<ContactAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.contact_row, parent, false))
    }

    override fun getItemCount(): Int = contacts?.size!!

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val contacts = contacts?.get(position)
        val location = contacts?.loc
        holder.locationText.text = location
        holder.contact.text = contacts?.number
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val locationText =  itemView.findViewById(R.id.location) as MaterialTextView
        val contact =  itemView.findViewById(R.id.contactVal) as MaterialTextView

    }
}