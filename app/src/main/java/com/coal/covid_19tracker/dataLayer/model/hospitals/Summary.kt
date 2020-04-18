package com.coal.covid_19tracker.dataLayer.model.hospitals

import com.google.gson.annotations.SerializedName

data class Summary(

	@field:SerializedName("ruralHospitals")
	val ruralHospitals: Int? = null,

	@field:SerializedName("urbanBeds")
	val urbanBeds: Int? = null,

	@field:SerializedName("totalHospitals")
	val totalHospitals: Int? = null,

	@field:SerializedName("totalBeds")
	val totalBeds: Int? = null,

	@field:SerializedName("ruralBeds")
	val ruralBeds: Int? = null,

	@field:SerializedName("urbanHospitals")
	val urbanHospitals: Int? = null
)