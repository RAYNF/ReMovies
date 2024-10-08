package com.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.domain.model.Movie
import com.example.removies.core.R


class AdapterMovie : RecyclerView.Adapter<AdapterMovie.ViewHolderClass>() {

    private var dataList = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null
    private val baseUrlImage = "https://image.tmdb.org/t/p/w500"

    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
        dataList.clear()
        dataList.addAll(newListData)
    }

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.img_movie)
        val rvTitle: TextView = itemView.findViewById(R.id.name_movie)
        val rvSubTitle: TextView = itemView.findViewById(R.id.name_gere)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_favorit, parent, false)
        return ViewHolderClass(view)
    }

    override fun getItemCount(): Int = dataList.size

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val movie = dataList[position]

        Glide.with(holder.itemView.context)
            .load(baseUrlImage + movie.image)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.error_image)
            .into(holder.rvImage)

        holder.rvTitle.text = movie.name
        holder.rvSubTitle.text = movie.description
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(movie)
        }
    }
}