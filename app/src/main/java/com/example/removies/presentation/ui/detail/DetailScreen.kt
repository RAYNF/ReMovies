package com.example.removies.presentation.ui.detail

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.domain.model.Movie
import com.example.removies.R
import com.example.removies.databinding.ActivityDetailSceenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailScreen : AppCompatActivity() {
    companion object {
        const val MOVIE_DETAIL_KEY = "MOVIE_DETAIL"
    }

    private lateinit var binding: ActivityDetailSceenBinding
    private val detailViewModel: DetailViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailSceenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val movie = intent.getParcelableExtra<Movie>(MOVIE_DETAIL_KEY)
        movie?.let {
            var isFavorite = movie.isFavorite
            loadImage(
                binding.imageMovie, "https://image.tmdb.org/t/p/w500/${it.image}"
            )
            loadImage(
                binding.movieBackground,
                "https://image.tmdb.org/t/p/w500/${it.backgroundImage}"
            )
            binding.movieName.text = it.name
            binding.movieRating.text = it.like.toString()
            binding.movieOverview.text = it.description
            binding.movieId.text = it.movieId
            binding.moviePopularity.text = it.popularity.toString()
            binding.favorite.setOnClickListener {
                isFavorite = !isFavorite
                detailViewModel.setFavoriteMovie(movie, isFavorite)
                Toast.makeText(
                    this,
                    if (isFavorite)
                        "Film Disimpan"
                    else
                        "Film Dihapus",
                    Toast.LENGTH_SHORT
                ).show()
            }


        }
        binding.btnClose.setOnClickListener {
            finish()
        }
    }

    private fun loadImage(imageView: ImageView, url: String?) {
        Glide.with(this)
            .load(url)
            .placeholder(R.drawable.placeholder_image)
            .error(R.drawable.error_image)
            .into(imageView)
    }
}