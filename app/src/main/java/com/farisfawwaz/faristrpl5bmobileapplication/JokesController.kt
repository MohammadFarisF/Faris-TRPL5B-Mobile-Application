package com.farisfawwaz.faristrpl5bmobileapplication

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitAPI {
    @GET("69193162833e6af3c1ca")
    fun getJokes(): Call<List<JokesModal>>
}