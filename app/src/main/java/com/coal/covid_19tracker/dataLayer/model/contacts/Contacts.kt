package com.coal.covid_19tracker.dataLayer.model.contacts

import com.google.gson.annotations.SerializedName

data class Contacts(

	@field:SerializedName("lastRefreshed")
	val lastRefreshed: String? = null,

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("success")
	val success: Boolean? = null,

	@field:SerializedName("lastOriginUpdate")
	val lastOriginUpdate: String? = null,

	@field:SerializedName("regional")
	val regional: List<RegionalItem?>? = null,

	@field:SerializedName("primary")
	val primary: Primary? = null
)