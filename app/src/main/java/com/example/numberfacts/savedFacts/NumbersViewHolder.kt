package com.example.numberfacts.savedFacts

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.numberfacts.db.entity.TriviaNumberEntity
import kotlinx.android.synthetic.main.numbers_item.view.*

class NumbersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private var title = itemView.title_number
    private var info = itemView.number_info

    fun bind(item: TriviaNumberEntity) {
        info.text = item.text_info
        title.text = item.number.toString()
    }
}