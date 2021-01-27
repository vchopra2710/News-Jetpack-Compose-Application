package com.proj.news.presentation.fragment.map

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.MarkerOptions
import com.proj.news.R
import com.proj.news.databinding.FragmentMapBinding
import com.proj.news.domain.model.Country
import com.proj.news.util.buildCountryList
import com.proj.news.util.getResBitmap
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MapFragment : Fragment() {

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
                MaterialTheme {
                    AndroidViewBinding(FragmentMapBinding::inflate) {

                        // setting bundle:null oncreate map
                        mapView.onCreate(null)

                        // sync map
                        mapView.getMapAsync { map ->

                            // resume map
                            mapView.onResume()

                            // add markers of supported countries
                            addMultipleMarker(map)

                            // add marker onclick listener
                            map?.setOnMarkerClickListener { marker ->

                                marker?.let {

                                    // add title and tag to bundle
                                    val bundle = bundleOf(
                                        requireContext().getString(R.string.country_name_tag) to it.title,
                                        requireContext().getString(R.string.country_alpha_code_tag) to it.tag
                                    )

                                    // navigate to news fragment with bundle [{cntry_name=India, cntry_alpha_code=in}
                                    findNavController().navigate(
                                        R.id.action_mapFragment_to_articleListFragment,
                                        bundle
                                    )
                                }

                                false
                            }
                        }
                    }
                }
            }
        }
    }

    private fun addMultipleMarker(mMap: GoogleMap?) {
        // set map type type to normal
        mMap?.mapType = GoogleMap.MAP_TYPE_NORMAL

        // loop through countries
        countries.forEach { country ->
            // add marker to map
            mMap?.addMarker(
                MarkerOptions().position(country.latLng).title(country.name)
                    .icon(
                        BitmapDescriptorFactory.fromBitmap(
                            getResBitmap(requireContext(), country.resId)
                        )
                    )
            )?.tag = country.alpha2Code

            // focus on map
            if (country.focused) mMap?.moveCamera(CameraUpdateFactory.newLatLng(country.latLng))
        }
    }
}