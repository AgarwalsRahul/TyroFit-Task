package com.notesync.tyrofit.framework.presentation.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.notesync.tyrofit.R
import com.notesync.tyrofit.businesss.domain.model.Cardio
import com.notesync.tyrofit.util.printLogD

class ListAdapter:
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Cardio>() {

        override fun areItemsTheSame(oldItem: Cardio, newItem: Cardio): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Cardio, newItem: Cardio): Boolean {
            return oldItem == newItem
        }

    }
    private val differ = AsyncListDiffer(this, DIFF_CALLBACK)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

        return NoteViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.layout_list_item,
                parent,
                false
            ),
        )
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NoteViewHolder -> {
                holder.bind(differ.currentList[position], position)
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    fun submitList(list: List<Cardio>) {
//        val commitCallback = Runnable {
//            // if process died must restore list position
//            // very annoying
//            interaction?.restoreListPosition()
//        }
        printLogD("listadapter", "size: ${list.size}")
        differ.submitList(list)
    }

    fun getNote(index: Int): Cardio? {
        return try {
            differ.currentList[index]
        } catch (e: IndexOutOfBoundsException) {
            e.printStackTrace()
            null
        }
    }

    class NoteViewHolder
    constructor(
        itemView: View,
    ) : RecyclerView.ViewHolder(itemView) {


        private lateinit var cardio: Cardio

        fun bind(item: Cardio, position: Int) = with(itemView) {
            cardio = item
            findViewById<TextView>(R.id.excersise_text).text = item.name
            findViewById<TextView>(R.id.trainer_name_text).setText(item.trainer_name)
            findViewById<TextView>(R.id.difficulty_level_text).setText(
                item.difficulty_level_name
            )
        }
    }


}