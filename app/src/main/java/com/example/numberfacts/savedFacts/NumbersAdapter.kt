package com.example.numberfacts.savedFacts

import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.numberfacts.R
import com.example.numberfacts.db.entity.TriviaNumberEntity
import kotlinx.android.synthetic.main.numbers_item.view.*


class NumbersAdapter : RecyclerView.Adapter<NumbersAdapter.NumbersViewHolder>() {

    private val listNumbers: MutableList<TriviaNumberEntity> = mutableListOf()

    class NumbersViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private var title: TextView = itemView.title_number
        private var info: TextView = itemView.number_info

        fun bind(item: TriviaNumberEntity) {
            info.text = item.text_info
            title.text = item.number.toString()
        }
    }

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