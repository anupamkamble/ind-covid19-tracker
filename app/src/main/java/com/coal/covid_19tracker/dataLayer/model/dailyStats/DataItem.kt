package com.coal.covid_19tracker.dataLayer.model.dailyStats

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("summary")
	val summary: Summary? = null,

	@field:SerializedName("regional")
	val regional: List<RegionalItem?>? = null,

	@field:SerializedName("day")
	val day: String? = null
)