package com.example.numberfacts.math_screen

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.numberfacts.R
import com.example.numberfacts.isVisible
import com.example.numberfacts.model.NumbersInfoModel
import kotlinx.android.synthetic.main.activity_math.*
import kotlinx.android.synthetic.main.activity_math.btnSaveIntoDb
import kotlinx.android.synthetic.main.activity_math.btnSearch
import kotlinx.android.synthetic.main.activity_math.enterNum
import kotlinx.android.synthetic.main.activity_math.toolbar
import kotlinx.android.synthetic.main.activity_trivia.*

class MathActivity : AppCompatActivity(), MathContractView {

    private val presenter: MathPresenter by lazy {
        MathPresenter(this, NumbersInfoModel(this))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_math)

        presenter.btnState(enterNum.text.isEmpty())

        toolbar.run {
            setNavigationOnClickListener {
                finish()
                true
            }
        }

        btnSaveIntoDb.setOnClickListener {
            presenter.saveMathNumber()
        }

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
        mathInfo.text = text
    }

    override fun btnSetText(text: Int) {
        btnSearch.setText(text)
    }

    override fun showError() {
        mathInfo.text = getString(R.string.error_result_server)
    }

    override fun showProgress(isShow: Boolean) {
        btnSearch.isVisible(!isShow)
        mathProgressBar.isVisible(isShow)
    }

    override fun saveIntoDb() {
        presenter.saveMathNumber()
    }

    override fun showSuccessfulSave() {
        Toast.makeText(this, R.string.successful_save_into_db_notification_text, Toast.LENGTH_SHORT).show()
    }

    override fun showSaveBtn(isShow: Boolean) {
        btnSaveIntoDb.isVisible(isShow)
    }
}