package com.example.removies.presentation.ui.detail

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide
import com.example.removies.R
import com.domain.model.Movie
import com.example.removies.databinding.ActivityDetailSceenBinding
import com.google.android.material.imageview.ShapeableImageView
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailSceen : AppCompatActivity() {
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

        val movie = intent.getParcelableExtra<Movie>("MOVIE_DETAIL")
        movie?.let {
            val imageView = findViewById<ImageView>(R.id.imageMovie)
            val backgroundImage = findViewById<ShapeableImageView>(R.id.movie_background)
            val titleView = findViewById<TextView>(R.id.movie_name)
            val genreView = findViewById<TextView>(R.id.movie_rating)
            val obverView = findViewById<TextView>(R.id.movie_overview)
            val movieId = findViewById<TextView>(R.id.movieId)
            val moviePopularity = findViewById<TextView>(R.id.movie_popularity)
            var isFavorite = movie.isFavorite

            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500/${it.image}")
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .into(imageView)

            Glide.with(this)
                .load("https://image.tmdb.org/t/p/w500/${it.backgroundImage}")
                .placeholder(R.drawable.placeholder_image)
                .error(R.drawable.error_image)
                .into(backgroundImage)

            titleView.text = it.name
            genreView.text = it.like.toString()
            obverView.text = it.description
            movieId.text = it.movieId
            moviePopularity.text = it.popularity.toString()


            binding.favorite.setOnClickListener {
                isFavorite = !isFavorite
                detailViewModel.setFavoriteMovie(movie, isFavorite)

                if (isFavorite) {
                    Toast.makeText(this, "di simpan", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "di hapus", Toast.LENGTH_SHORT).show()
                }
            }


        }
        val closeButton = findViewById<ImageButton>(R.id.btn_close)
        closeButton.setOnClickListener {
            finish()
        }
    }
}