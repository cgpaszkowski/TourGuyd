package com.example.tourguyd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.services.android.navigation.v5.navigation.MapboxNavigation

class MainActivity : AppCompatActivity() {

    private lateinit var mapView: MapView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navigation = MapboxNavigation(applicationContext, "@String/MAPBOX_ACCESS_TOKEN")
        Mapbox.getInstance(applicationContext, getString(R.string.MAPBOX_ACCESS_TOKEN))
        mapView = findViewById(R.id.mapView)
        mapView.onCreate(savedInstanceState)

    }
}
