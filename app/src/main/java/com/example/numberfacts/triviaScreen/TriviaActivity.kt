package com.example.numberfacts.triviaScreen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import com.example.numberfacts.R
import com.example.numberfacts.isVisible
import com.example.numberfacts.model.NumbersInfoModel
import kotlinx.android.synthetic.main.activity_trivia.*

class TriviaActivity : AppCompatActivity(), TriviaContractView {


    private val presenter: TriviaPresenter by lazy {
        TriviaPresenter(this, NumbersInfoModel())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trivia)


        presenter.btnState(enterNum.text.isEmpty())

        enterNum.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable?) {

                presenter.btnState(enterNum.text.isEmpty())

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        btnSearch.setOnClickListener {
            presenter.getNumberInfo(enterNum.text.toString())
        }
    }

    override fun setTextInfoAboutNumber(text: String) {
        triviaInfo.text = text
    }

    override fun btnSetText(text: Int) {
        btnSearch.setText(text)
    }

    override fun showError() {
        triviaInfo.text = getString(R.string.error_result_server)
    }

    override fun showProgress(isShow: Boolean) {
        btnSearch.isVisible(!isShow)
        progressBar.isVisible(isShow)
    }
}





