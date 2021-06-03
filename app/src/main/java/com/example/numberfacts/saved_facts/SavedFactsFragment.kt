package com.example.numberfacts.saved_facts

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.numberfacts.R
import com.example.numberfacts.db.entity.TriviaNumberEntity
import com.example.numberfacts.model.NumbersInfoModel
import kotlinx.android.synthetic.main.fragment_saved_facts.*

class SavedFactsFragment : Fragment(), SavedFactsContactView {

    private val numberAdapter: NumbersAdapter = NumbersAdapter()

    private val presenter: SavedNumbersPresenter by lazy {
        SavedNumbersPresenter(this, NumbersInfoModel(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? =
        inflater.inflate(R.layout.fragment_saved_facts, container, false)

    override fun onOptionsItemSelected(item: MenuItem): Boolean =
        when (item.itemId) {
            R.id.trivia_item -> {
                true
            }
            R.id.math_item -> {
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvNumbers = rvFacts

        toolbar.inflateMenu(R.menu.category_saved_facts_menu)
        toolbar.setTitleTextColor(Color.WHITE)

        rvNumbers.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = numberAdapter
        }
    }

    override fun onResume() {
        super.onResume()

        presenter.getNumbersListFromDb()
    }

    override fun showNumberList(numberList: List<TriviaNumberEntity>) {
        numberAdapter.setData(numberList)
    }
}