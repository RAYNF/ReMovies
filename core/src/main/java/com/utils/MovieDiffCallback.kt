package com.utils

import androidx.recyclerview.widget.DiffUtil
import com.domain.model.Movie

class MovieDiffCallback(
    private val oldList: List<Movie>,
    private val newList: List<Movie>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].movieId == newList[newItemPosition].movieId
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}