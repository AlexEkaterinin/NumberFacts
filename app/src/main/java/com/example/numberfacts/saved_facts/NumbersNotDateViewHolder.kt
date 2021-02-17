package com.example.numberfacts.saved_facts

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.numberfacts.db.entity.NumbersNotDateInfo
import com.example.numberfacts.db.entity.TriviaNumberEntity
import kotlinx.android.synthetic.main.numbers_item.view.*

class NumbersNotDateViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var title = itemView.title_number
    private var info = itemView.number_info

    fun bind(item: NumbersNotDateInfo) {
        info.text = item.textInfo
        title.text = item.number.toString()
    }
}