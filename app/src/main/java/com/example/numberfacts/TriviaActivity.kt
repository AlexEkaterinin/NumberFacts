package com.example.numberfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TriviaActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var numberInfo: TextView
    lateinit var currentNum: TextView
    lateinit var captionNum: TextView
    lateinit var enterNum: EditText
    lateinit var btnSearch: Button
    lateinit var progressBar: ProgressBar
    private lateinit var call: Call<NumberNotDate>
    private val request = ServiceBuilder.buildService(NumbersApi::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trivia)

        numberInfo = findViewById(R.id.trivia_info)

        enterNum = findViewById(R.id.enterNum)
        btnSearch = findViewById(R.id.btnSearch)
        currentNum = findViewById(R.id.current_number)
        progressBar = findViewById(R.id.progressBar)
        captionNum = findViewById(R.id.caption_of_current_number)

        progressBar.visibility = View.GONE
        captionNum.visibility = View.GONE

        btnSearch.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        viewSearchStart()
        var contentEdit = enterNum.text.toString()

        call = if (TextUtils.isEmpty(contentEdit)) {
            request.getRandomNumberNotDate("trivia")
        } else {
            request.getNumberNotDate(contentEdit, "trivia")
        }

        call.enqueue(object : Callback<NumberNotDate> {
            override fun onResponse(call: Call<NumberNotDate>, response: Response<NumberNotDate>) {
                if (response.isSuccessful) {
                    viewSearchEnd()
                    captionNum.visibility = View.VISIBLE
                    setInfo(response.body())
                    Log.d("response", response.body().toString())
                } else {
                    Log.d("response", response.code().toString())
                }
            }

            override fun onFailure(call: Call<NumberNotDate>, t: Throwable) {
                viewSearchEnd()
                Toast.makeText(this@TriviaActivity, t.toString(), Toast.LENGTH_LONG).show()
                Log.d("failure", t.toString())
            }
        })
    }

    fun setInfo(result: NumberNotDate?) {
        numberInfo.text = result?.text
        currentNum.text = result?.number.toString()
    }

    fun viewSearchStart() {
        btnSearch.visibility = View.GONE
        progressBar.visibility = View.VISIBLE
    }

    fun viewSearchEnd() {
        btnSearch.visibility = View.VISIBLE
        progressBar.visibility = View.GONE
    }
}



