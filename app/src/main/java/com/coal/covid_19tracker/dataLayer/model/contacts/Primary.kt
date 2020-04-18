package com.coal.covid_19tracker.dataLayer.model.contacts

import com.google.gson.annotations.SerializedName

data class Primary(

	@field:SerializedName("number")
	val number: String? = null,

	@field:SerializedName("twitter")
	val twitter: String? = null,

	@field:SerializedName("number-tollfree")
	val numberTollfree: String? = null,

	@field:SerializedName("facebook")
	val facebook: String? = null,

	@field:SerializedName("media")
	val media: List<String?>? = null,

	@field:SerializedName("email")
	val email: String? = null
)