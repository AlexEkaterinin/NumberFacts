package com.example.numberfacts.model

import android.util.Log
import com.example.numberfacts.ServiceBuilder
import com.example.numberfacts.api.NumbersApi
import retrofit2.Call
import java.lang.Exception

class NumbersInfoModel {

    private val request = ServiceBuilder.buildService(NumbersApi::class.java)

    suspend fun requestServer(text: String): String? {
        val call = if (text.isEmpty()) {
            request.getRandomNumberNotDate(TRIVIA_PATH)
        } else {
            request.getNumberNotDate(text, TRIVIA_PATH)
        }

        return try {
            val response = call.execute()
            response.body()?.text
        } catch (cat: Exception) {
            null
        }
    }

    companion object {
        const val TRIVIA_PATH = "trivia"
    }
}