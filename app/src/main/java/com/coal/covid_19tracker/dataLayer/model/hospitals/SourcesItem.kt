package com.coal.covid_19tracker.dataLayer.model.hospitals

import com.google.gson.annotations.SerializedName

data class SourcesItem(

	@field:SerializedName("lastUpdated")
	val lastUpdated: String? = null,

	@field:SerializedName("url")
	val url: String? = null
)