package com.example.numberfacts.model

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.numberfacts.ServiceBuilder
import com.example.numberfacts.api.NumbersApi
import com.example.numberfacts.db.NumberDatabase
import com.example.numberfacts.db.TriviaNumbersDao
import com.example.numberfacts.db.entity.TriviaNumberEntity
import retrofit2.Call
import java.lang.Exception

class NumbersInfoModel(
    context: Context
) {

    private val request = ServiceBuilder.buildService(NumbersApi::class.java)

    val db = NumberDatabase.getInstance(context)

    suspend fun requestServer(text: String): TriviaNumberEntity {
        val call = if (text.isEmpty()) {
            request.getRandomNumberNotDate(TRIVIA_PATH)
        } else {
            request.getNumberNotDate(text, TRIVIA_PATH)
        }

        val response = call.execute().body()

        return TriviaNumberEntity(
            text_info = response?.text,
            number = response?.number?.toLong()
        )
    }

    fun insertNumberDb(numberInfo: TriviaNumberEntity) {
        db.triviaNumbersDao().insertNumberInfo(numberInfo)
    }

    companion object {
        const val TRIVIA_PATH = "trivia"
    }
}