package com.coal.covid_19tracker.dataLayer.model.contacts

import com.google.gson.annotations.SerializedName

data class RegionalItem(

	@field:SerializedName("loc")
	val loc: String? = null,

	@field:SerializedName("number")
	val number: String? = null
)