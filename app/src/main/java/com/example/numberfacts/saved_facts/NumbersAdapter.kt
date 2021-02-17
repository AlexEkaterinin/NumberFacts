package com.example.numberfacts.saved_facts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.numberfacts.R
import com.example.numberfacts.db.entity.TriviaNumberEntity


class NumbersAdapter : RecyclerView.Adapter<NumbersViewHolder>() {

    private val listNumbers: MutableList<Any> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.numbers_item, parent, false)
        return NumbersViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumbersViewHolder, position: Int) {
        holder.bind(listNumbers[position] as TriviaNumberEntity)
    }

    override fun getItemCount(): Int {
        return listNumbers.size
    }

    fun setData(list: List<Any>) {
        listNumbers.clear()
        listNumbers.addAll(list)
        notifyDataSetChanged()
    }
}
