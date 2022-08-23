package com.dilara.vitrinovanew.data.remote

import com.dilara.vitrinovanew.data.model.DiscoverModel
import retrofit2.Response
import retrofit2.http.GET

interface ServiceApi {
    @GET("discover")
    suspend fun getDiscover(): Response<DiscoverModel>
}