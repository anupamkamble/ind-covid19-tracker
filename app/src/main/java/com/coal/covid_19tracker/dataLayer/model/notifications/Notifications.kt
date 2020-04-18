package com.coal.covid_19tracker.dataLayer.model.notifications

import com.google.gson.annotations.SerializedName

data class Notifications(

	@field:SerializedName("lastRefreshed")
	val lastRefreshed: String? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("lastOriginUpdate")
	val lastOriginUpdate: String? = null
)