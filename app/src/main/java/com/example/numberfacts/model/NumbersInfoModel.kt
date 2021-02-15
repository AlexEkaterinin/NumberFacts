package com.example.numberfacts.model

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.room.Room
import com.example.numberfacts.ServiceBuilder
import com.example.numberfacts.api.NumbersApi
import com.example.numberfacts.db.NumberDatabase
import com.example.numberfacts.db.TriviaNumbersDao
import com.example.numberfacts.db.entity.Fact
import com.example.numberfacts.db.entity.TriviaNumberEntity
import retrofit2.Call
import java.lang.Exception

class NumbersInfoModel(
    context: Context
) {

    private val request = ServiceBuilder.buildService(NumbersApi::class.java)

    val db = NumberDatabase.getInstance(context)

    fun requestServer(text: String): Fact {
        val call = if (text.isEmpty()) {
            request.getRandomNumberNotDate(TRIVIA_PATH)
        } else {
            request.getNumberNotDate(text, TRIVIA_PATH)
        }

        val response = call.execute().body()

        List

        return TriviaNumberEntity(
            text_info = response?.text,
            number = response?.number
        )
    }

    fun insertNumberDb(numberInfo: TriviaNumberEntity) {
        db.triviaNumbersDao().insertNumberInfo(numberInfo)
    }

    fun getAllTriviaNumbers(): List<TriviaNumberEntity> {
        return db.triviaNumbersDao().getAll()
    }

    companion object {
        const val TRIVIA_PATH = "trivia"
    }
}