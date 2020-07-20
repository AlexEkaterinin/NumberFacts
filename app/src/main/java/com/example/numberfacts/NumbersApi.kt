package com.example.numberfacts


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface NumbersApi {
    @GET("{number}/{type}?json")
    fun getNumberNotDate(
        @Path("number") number: String,
        @Path("type") type: String
    ): Call<NumberNotDate>

    @GET("random/{type}?json")
    fun getRandomNumberNotDate(
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