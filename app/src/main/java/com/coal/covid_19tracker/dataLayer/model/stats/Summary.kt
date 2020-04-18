package com.coal.covid_19tracker.dataLayer.model.stats

import com.google.gson.annotations.SerializedName

data class Summary(

	@field:SerializedName("total")
	val total: Int? = null,

	@field:SerializedName("confirmedButLocationUnidentified")
	val confirmedButLocationUnidentified: Int? = null,

	@field:SerializedName("confirmedCasesForeign")
	val confirmedCasesForeign: Int? = null,

	@field:SerializedName("discharged")
	val discharged: Int? = null,

	@field:SerializedName("confirmedCasesIndian")
	val confirmedCasesIndian: Int? = null,

	@field:SerializedName("deaths")
	val deaths: Int? = null
)