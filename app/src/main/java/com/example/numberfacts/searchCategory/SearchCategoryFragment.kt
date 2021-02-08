package com.example.numberfacts.searchCategory

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.numberfacts.*
import com.example.numberfacts.triviaScreen.TriviaActivity
import kotlinx.android.synthetic.main.search_category_screen.*

class SearchCategoryFragment : Fragment(), SearchCategoryContractView {

    private val presenter: SearchCategoryPresenter = SearchCategoryPresenter(this)
    private val TRIVIA_ACTIVITY_CLASS = TriviaActivity::class.java
    private val MATH_ACTIVITY_CLASS = MathActivity::class.java
    private val DATE_ACTIVITY_CLASS = DateActivity::class.java
    private val YEAR_ACTIVITY_CLASS = YearActivity::class.java

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_category_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        startActivity(Intent(activity, cls))
    }
}