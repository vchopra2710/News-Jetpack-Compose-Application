package com.proj.news.presentation.fragment.map

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.proj.news.R
import com.proj.news.domain.model.Country
import com.proj.news.util.buildCountryList
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MapFragment : Fragment(R.layout.fragment_map), OnMapReadyCallback,
    GoogleMap.OnMarkerClickListener {

    private lateinit var countries: List<Country>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        countries = buildCountryList()
        (childFragmentManager.findFragmentById(R.id.map_view) as SupportMapFragment).getMapAsync(
            this
        )
    }

    override fun onMapReady(p0: GoogleMap?) {
        p0?.setOnMarkerClickListener(this)
        addMultipleMarker(p0)
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        val bundle = bundleOf(
            requireContext().getString(R.string.country_name_tag) to p0?.title,
            requireContext().getString(R.string.country_alpha_code_tag) to p0?.tag
        )
        findNavController().navigate(R.id.action_mapFragment_to_articleListFragment, bundle)
        return true
    }

    private fun addMultipleMarker(mMap: GoogleMap?) {
        for (country in countries) {
            mMap?.addMarker(
                MarkerOptions().position(country.latLng).title(country.name)
            )?.tag = country.alpha2Code

            if (country.focused) {
                mMap?.moveCamera(CameraUpdateFactory.newLatLng(country.latLng))
            }
        }
    }
}