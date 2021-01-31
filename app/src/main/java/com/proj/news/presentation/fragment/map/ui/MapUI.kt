package com.proj.news.presentation.fragment.map.ui

import android.content.Context
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.AmbientContext
import androidx.compose.ui.viewinterop.AndroidViewBinding
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.MarkerOptions
import com.proj.news.R
import com.proj.news.databinding.FragmentMapBinding
import com.proj.news.domain.model.Country

@Composable
fun PopulateMap(
    ctx: Context = AmbientContext.current,
    nav: NavController,
    countries: List<Country>?,
    mapType: Int
) {
    AndroidViewBinding(FragmentMapBinding::inflate) {

        // setting bundle:null oncreate map
        mapView.onCreate(null)

        // sync map
        mapView.getMapAsync { map ->

            // resume map
            mapView.onResume()

            // add markers of supported countries
            addMultipleMarker(map, countries, mapType)

            // add marker onclick listener
            map?.setOnMarkerClickListener { marker ->

                marker?.let {

                    // add title and tag to bundle [{cntry_name=India, cntry_alpha_code=in}
                    val bundle = bundleOf(
                        ctx.getString(R.string.country_name_tag) to it.title,
                        ctx.getString(R.string.country_alpha_code_tag) to it.tag
                    )

                    // navigate to news fragment with bundle
                    nav.navigate(R.id.action_mapFragment_to_articleListFragment, bundle)
                }

                false
            }
        }
    }

}

private fun addMultipleMarker(
    mMap: GoogleMap?,
    countries: List<Country>?,
    mapType: Int
) {
    // set map type type to normal
    mMap?.mapType = mapType

    // loop through countries
    countries?.forEach { country ->
        // add marker to map
        mMap?.addMarker(
            MarkerOptions().position(country.latLng).title(country.name)
//                .icon(BitmapDescriptorFactory.fromBitmap(getResBitmap(ctx, country.resId)))
        )?.tag = country.alpha2Code

        // focus on map
        if (country.focused) mMap?.moveCamera(CameraUpdateFactory.newLatLng(country.latLng))
    }
}