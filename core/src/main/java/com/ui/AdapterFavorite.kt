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


class AdapterFavorite : RecyclerView.Adapter<AdapterFavorite.ViewHolderClass>() {

    private val dataList = ArrayList<Movie>()
    var onItemClick: ((Movie) -> Unit)? = null
    private val baseUrlImage = "https://image.tmdb.org/t/p/w500"

    fun setData(newListData: List<Movie>?) {
        if (newListData == null) return
        dataList.clear()
        dataList.addAll(newListData)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderClass {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(com.example.removies.core.R.layout.item_movie, parent, false)
        return ViewHolderClass(view)
    }

    override fun onBindViewHolder(holder: ViewHolderClass, position: Int) {
        val movie = dataList[position]

        Glide.with(holder.itemView.context)
            .load(baseUrlImage + movie.image) // Menggabungkan URL dasar dengan path gambar dari MovieEntity
            .placeholder(R.drawable.placeholder_image) // Gambar placeholder saat menunggu loading
            .error(R.drawable.error_image) // Gambar saat terjadi kesalahan memuat gambar
            .into(holder.rvImage)

        holder.rvTitle.text = movie.name
        holder.rvSubTitle.text = movie.description
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(movie)
        }

    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    class ViewHolderClass(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rvImage: ImageView = itemView.findViewById(R.id.imageMovie)
        val rvTitle: TextView = itemView.findViewById(com.example.removies.core.R.id.nameMovie)
        val rvSubTitle: TextView = itemView.findViewById(com.example.removies.core.R.id.genreMovie)
    }

}