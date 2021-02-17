package com.example.numberfacts.saved_facts

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.numberfacts.R
import com.example.numberfacts.db.entity.NumbersNotDateInfo
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.category_saved_facts_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvNumbers = rvFacts

        rvNumbers.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = numberAdapter
        }

        toolbar.run {
            inflateMenu(R.menu.category_saved_facts_menu)

            setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.trivia_item -> {
                        presenter.showNumbersList(TRIVIA_CATEGORY)
                        true
                    }
                    R.id.math_item -> {
                        presenter.showNumbersList(MATH_CATEGORY)
                        true
                    }
                    else -> super.onOptionsItemSelected(menuItem)
                }
            }
        }

        presenter.showNumbersList(TRIVIA_CATEGORY)
    }

    override fun showNumberList(numberList: List<NumbersNotDateInfo>) {
        numberAdapter.setData(numberList)
    }

    override fun titleSetText(text: String) {
        toolbar_title_text.text = text
    }

    companion object {
        const val TRIVIA_CATEGORY = "TRIVIA"
        const val MATH_CATEGORY = "MATH"
    }
}