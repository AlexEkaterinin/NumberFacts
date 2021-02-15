package com.example.numberfacts.model

import android.content.Context
import com.example.numberfacts.ServiceBuilder
import com.example.numberfacts.api.NumbersApi
import com.example.numberfacts.db.NumberDatabase
import com.example.numberfacts.db.entity.TriviaNumberEntity

class NumbersInfoModel(
    context: Context
) {

    private val request = ServiceBuilder.buildService(NumbersApi::class.java)

    val db = NumberDatabase.getInstance(context)

    fun requestServer(text: String): TriviaNumberEntity {
        val call = if (text.isEmpty()) {
            request.getRandomNumberNotDate(TRIVIA_PATH)
        } else {
            request.getNumberNotDate(text, TRIVIA_PATH)
        }

        val response = call.execute().body()

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