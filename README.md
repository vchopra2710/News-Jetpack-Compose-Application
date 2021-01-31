# News

Android studio project to display lates news of supported counties

[Jetpack Compose (1.0.0-alpha10)](https://developer.android.com/jetpack/compose?gclid=Cj0KCQiAx9mABhD0ARIsAEfpavRejTUy93es9DecTJmgm99FCWndsH-a7LR03alRWdoWLldKU6YMCXwaAnGBEALw_wcB&gclsrc=aw.ds)
* Add google maps(com.google.android.gms.maps.MapView) to jetpack compose by using [Interoperability](https://developer.android.com/jetpack/compose/interop)
    * use [AndroidViewBinding](https://developer.android.com/jetpack/compose/interop#views-in-compose) to bind layout file to compose.
* [FAB (Floating Action Button)](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#floatingactionbutton) for changing map type
    * MAP_TYPE_SATELLITE
    * MAP_TYPE_TERRAIN
    * MAP_TYPE_HYBRID
* Use [Scaffold](https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#scaffold) to add fab to compose and animate it.