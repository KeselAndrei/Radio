package com.gmail.keseltms.cloud

class ApiRepository(
    private val radioApi: RadioApi
) {
    suspend fun getApiResult(
        country:String,
        tags: String,
        limit: Int,
    ): RadioStations = radioApi.getRadio(
        country,
        tags,
        limit
    )
}