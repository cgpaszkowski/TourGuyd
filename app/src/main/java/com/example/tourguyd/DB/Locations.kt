package com.example.tourguyd.DB

import com.mapbox.mapboxsdk.maps.MapFragment

class Locations {
    var Monuments: String
    var routes: MapFragment

    constructor(Monuments:String, routes:MapFragment){
        this.Monuments = Monuments
        this.routes=routes
    }
}