package com.example.challenge2.api

import com.example.challenge2.item.CovidCountryItem
import retrofit2.Call
import retrofit2.http.GET

interface CountryService {
    @GET( "/" )
    fun getCountry(): Call<List<CovidCountryItem>>
}