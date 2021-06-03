package com.example.numberfacts.model

import android.content.Context
import com.example.numberfacts.ServiceBuilder
import com.example.numberfacts.api.NumbersApi
import com.example.numberfacts.db.NumberDatabase
import com.example.numberfacts.db.entity.MathNumberEntity
import com.example.numberfacts.db.entity.NumbersNotDateInfo
import com.example.numberfacts.db.entity.TriviaNumberEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class NumbersInfoModel(
    context: Context
) {

    private val request = ServiceBuilder.buildService(NumbersApi::class.java)

    val db = NumberDatabase.getInstance(context)

    suspend fun getNumberNotDateInfo(number: String, category: String): NumbersNotDateInfo {
        return suspendCoroutine { continuation ->

            val call = request.getNumberNotDate(number.ifEmpty { RANDOM_PATH }, category)

            call.enqueue(object : Callback<NumberNotDate> {

                override fun onResponse(
                    call: Call<NumberNotDate>,
                    response: Response<NumberNotDate>
                ) {
                    val answer = response.body() as NumberNotDate

                    continuation.resumeWith(
                        Result.success(
                            when (category) {
                                TRIVIA_PATH -> {
                                    TriviaNumberEntity(
                                        textInfo = answer.text,
                                        number = answer.number
                                    )
                                }
                                else -> {
                                    MathNumberEntity(
                                        textInfo = answer.text,
                                        number = answer.number
                                    )
                                }
                            }
                        )
                    )
                }

                override fun onFailure(call: Call<NumberNotDate>, t: Throwable) {
                    continuation.resumeWithException(t)
                }
            })
        }
    }

    fun insertTriviaNumberDb(numberInfo: NumbersNotDateInfo) {
        db.triviaNumbersDao().insertNumberInfo(numberInfo as TriviaNumberEntity)
    }

    fun insertMathNumberDb(numberInfo: NumbersNotDateInfo) {
        db.mathNumbersDao().insertNumberInfo(numberInfo as MathNumberEntity)
    }

    fun getAllTriviaNumbers(): List<TriviaNumberEntity> {
        return db.triviaNumbersDao().getAll()
    }

    companion object {
        const val RANDOM_PATH = "random"

        const val TRIVIA_PATH = "trivia"
        const val MATH_PATH = "math"
    }
}