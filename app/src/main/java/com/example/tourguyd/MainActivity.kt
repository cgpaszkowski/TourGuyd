package com.example.tourguyd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mapbox.services.android.navigation.v5.navigation.MapboxNavigation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navigation = MapboxNavigation(this, "@string/MAPBOX_ACCESS_TOKEN")
    }
}
