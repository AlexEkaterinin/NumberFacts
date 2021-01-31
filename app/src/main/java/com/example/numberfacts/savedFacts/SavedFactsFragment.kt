package com.example.numberfacts.savedFacts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.numberfacts.R
import com.example.numberfacts.db.entity.TriviaNumberEntity
import com.example.numberfacts.model.NumbersInfoModel
import kotlinx.android.synthetic.main.fragment_saved_facts.*

class SavedFactsFragment : Fragment(), SavedFactsContactView {

    private lateinit var rvNumbers: RecyclerView
    private val numberAdapter: NumbersAdapter = NumbersAdapter()

    private val presenter: SavedNumbersPresenter by lazy {
        SavedNumbersPresenter(this, NumbersInfoModel(requireContext()))
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter.getNumbersListFromDb()
        return inflater.inflate(R.layout.fragment_saved_facts, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvNumbers = saved_facts_list

        rvNumbers.run {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = numberAdapter
        }
    }

    override fun showNumberList(numberList: List<TriviaNumberEntity>) {
        numberAdapter.setData(numberList)
    }
}