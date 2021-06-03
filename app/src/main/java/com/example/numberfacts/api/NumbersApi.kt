package com.example.numberfacts.api


import com.example.numberfacts.model.DateNumber
import com.example.numberfacts.model.NumberNotDate
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface NumbersApi {
    @GET("{number}/{type}?json")
    fun getNumberNotDate(
        @Path("number") number: String,
        @Path("type") type: String
    ): Call<NumberNotDate>

    @GET("{month}/{day}/date?json")
    fun getDateNumber(
        @Path("month") month: String,
        @Path("day") day: String
    ): Call<DateNumber>

    @GET("random/date?json")
    fun getRandomDateNumber(): Call<DateNumber>
}