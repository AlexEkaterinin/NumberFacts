package com.example.numberfacts.mainMenu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.numberfacts.*
import kotlinx.android.synthetic.main.main_menu.*

class MainActivity : AppCompatActivity(), MainMenuContractView {

    private val presenter: MainMenuPresenter = MainMenuPresenter(this)
    private val TRIVIA_ACTIVITY_CLASS = TriviaActivity::class.java
    private val MATH_ACTIVITY_CLASS = MathActivity::class.java
    private val DATE_ACTIVITY_CLASS = DateActivity::class.java
    private val YEAR_ACTIVITY_CLASS = YearActivity::class.java

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu)

        btnTrivia.setOnClickListener {
            presenter.clickMainMenuBtn(TRIVIA_ACTIVITY_CLASS)
        }

        btnMath.setOnClickListener {
            presenter.clickMainMenuBtn(MATH_ACTIVITY_CLASS)
        }

        btnDate.setOnClickListener {
            presenter.clickMainMenuBtn(DATE_ACTIVITY_CLASS)
        }

        btnYear.setOnClickListener {
            presenter.clickMainMenuBtn(YEAR_ACTIVITY_CLASS)
        }

    }

    override fun startActivity(cls: Class<*>) {
        startActivity(Intent(this, cls))
    }
}