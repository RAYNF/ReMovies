package com.example.removies.presentation.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.removies.R
import com.example.removies.databinding.FragmentHomeBinding
import com.example.removies.presentation.ui.detail.DetailScreen
import com.ui.AdapterMovie
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    companion object {
        const val MOVIE_DETAIL_KEY = "MOVIE_DETAIL"
    }

    private val homeViewModel: HomeViewModel by viewModel()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val adapterMovie = AdapterMovie()
            adapterMovie.onItemClick = { selectedMovie ->
                val intent = Intent(activity, DetailScreen::class.java)
                intent.putExtra(MOVIE_DETAIL_KEY, selectedMovie)
                startActivity(intent)
            }

            homeViewModel.movie.observe(viewLifecycleOwner) { movieList ->
                if (movieList != null) {
                    when (movieList) {
                        is com.data.source.Resource.Loading -> binding.progressBar.visibility =
                            View.VISIBLE

                        is com.data.source.Resource.Success -> {
                            binding.progressBar.visibility = View.GONE
                            adapterMovie.setData(movieList.data)

                            with(binding.rvRecomendationMovie) {
                                layoutManager = GridLayoutManager(requireActivity(), 2)
                                setHasFixedSize(true)
                                adapter = adapterMovie
                            }
                        }

                        is com.data.source.Resource.Error -> {
                            binding.progressBar.visibility = View.GONE
                            binding.viewError.root.visibility = View.VISIBLE
                            binding.viewError.tvError.text =
                                movieList.message ?: getString(R.string.something_wrong)
                        }
                    }
                }
            }


        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}