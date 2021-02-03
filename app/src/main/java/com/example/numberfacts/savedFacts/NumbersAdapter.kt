package com.example.numberfacts.savedFacts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.numberfacts.R
import com.example.numberfacts.db.entity.TriviaNumberEntity
import kotlinx.android.synthetic.main.numbers_item.view.*


class NumbersAdapter : RecyclerView.Adapter<NumbersViewHolder>() {

    private val listNumbers: MutableList<TriviaNumberEntity> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersViewHolder {
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.numbers_item, parent, false)
        return NumbersViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
        holder.bind(listNumbers[position])
    }

    override fun getItemCount(): Int {
        return listNumbers.size
    }

    fun setData(list: List<TriviaNumberEntity>) {
        listNumbers.addAll(list)
        notifyDataSetChanged()
    }
}
