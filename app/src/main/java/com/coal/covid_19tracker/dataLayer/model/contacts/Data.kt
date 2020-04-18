package com.coal.covid_19tracker.dataLayer.model.contacts

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("contacts")
	val contacts: Contacts? = null
)