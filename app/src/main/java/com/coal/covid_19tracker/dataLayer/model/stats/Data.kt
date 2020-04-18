package com.coal.covid_19tracker.dataLayer.model.stats

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("summary")
	val summary: Summary? = null,

	@field:SerializedName("regional")
	val regional: List<RegionalItem?>? = null
)