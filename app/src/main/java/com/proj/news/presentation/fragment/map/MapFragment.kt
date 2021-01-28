package com.proj.news.presentation.fragment.map

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.proj.news.domain.model.Country
import com.proj.news.util.buildCountryList
import com.proj.news.viewmodel.MapViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MapFragment : Fragment() {
    private val viewModel: MapViewModel by viewModels()
    private lateinit var countries: List<Country>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        countries = buildCountryList()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                PopulateMapFragmentUI(
                    nav = findNavController(),
                    countries = countries,
                    mapType = viewModel.mapType.value,
                    changeMapType = viewModel::updateMapType
                )
            }
        }
    }
}