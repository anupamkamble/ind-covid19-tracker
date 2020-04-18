package com.coal.covid_19tracker.dataLayer.model.notifications

import com.google.gson.annotations.SerializedName

data class Data(

	@field:SerializedName("notifications")
	val notifications: List<Any?>? = null
)