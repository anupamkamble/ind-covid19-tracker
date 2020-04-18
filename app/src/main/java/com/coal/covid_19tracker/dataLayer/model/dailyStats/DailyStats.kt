package com.coal.covid_19tracker.dataLayer.model.dailyStats

import com.google.gson.annotations.SerializedName

data class DailyStats(

	@field:SerializedName("lastRefreshed")
	val lastRefreshed: String? = null,

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("lastOriginUpdate")
	val lastOriginUpdate: String? = null
)