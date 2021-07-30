package com.gmail.keseltms.cloud

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.RequestBody
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface RadioApi {
    @Headers("x-rapidapi-key:6f3243a104msh59e8b6a0d49d86fp137775jsnbae005fc3529")
    @GET("json/stations/search?reverse=false&offset=0&hidebroken=false")
    suspend fun getRadio(
        @Query("country") country: String,
        @Query("tag") tags: String,
        @Query("limit") limit: Int
    ): RadioStations

    companion object {
        fun get(): RadioApi = Retrofit.Builder()
            .baseUrl("https://radio-browser.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build().create(RadioApi::class.java)
    }

}
