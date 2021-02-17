package com.example.numberfacts.saved_facts

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.numberfacts.R
import com.example.numberfacts.db.entity.NumbersNotDateInfo


class NumbersAdapter : RecyclerView.Adapter<NumbersNotDateViewHolder>() {

    private val listNumbers: MutableList<NumbersNotDateInfo> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NumbersNotDateViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.numbers_item, parent, false)
        return NumbersNotDateViewHolder(view)
    }

    override fun onBindViewHolder(holder: NumbersNotDateViewHolder, position: Int) {
        holder.bind(listNumbers[position])
    }

    override fun getItemCount(): Int {
        return listNumbers.size
    }

    fun setData(list: List<NumbersNotDateInfo>) {
        listNumbers.clear()
        listNumbers.addAll(list)
        notifyDataSetChanged()
    }
}
