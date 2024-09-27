package com.example.removies.favorite.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.removies.favorite.databinding.FragmentDashboardBinding
import com.example.removies.favoriteModule
import com.example.removies.presentation.ui.detail.DetailScreen
import com.ui.AdapterFavorite
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules

class DashboardFragment : Fragment() {

    companion object {
        const val MOVIE_DETAIL_KEY = "MOVIE_DETAIL"
    }

    private var _binding: FragmentDashboardBinding? = null
    private val dashboardViewModel: DashboardViewModel by viewModel()
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        loadKoinModules(favoriteModule)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val tourismAdapter = AdapterFavorite()
            tourismAdapter.onItemClick = { selectedMovie ->
                val intent = Intent(activity, DetailScreen::class.java)
                intent.putExtra(MOVIE_DETAIL_KEY, selectedMovie)
                startActivity(intent)
            }

            dashboardViewModel.favoriteMovie.observe(viewLifecycleOwner) { dataTourism ->
                tourismAdapter.setData(dataTourism)
                binding.viewEmpty.root.visibility =
                    if (dataTourism.isNotEmpty()) View.GONE else View.VISIBLE
            }

            with(binding.rvFavoriteMovie) {
                layoutManager = LinearLayoutManager(requireActivity())
                setHasFixedSize(true)
                adapter = tourismAdapter
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}