package com.example.numberfacts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.*
import androidx.core.widget.addTextChangedListener
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

        enterNum.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                val enterText: String = enterNum.text.toString()

                btnSearch.setText(
                    when(TextUtils.isEmpty(enterText)) {
                        true -> R.string.button_search_text_empty_enter
                        false -> R.string.button_search_text_not_empty_enter
                    }
                )
            }
        })

        progressBar.visibility = View.GONE
        captionNum.visibility = View.GONE

        btnSearch.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        viewSearchStart()
        val contentEdit = enterNum.text.toString()

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



