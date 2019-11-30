package com.example.tourguyd

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rv_tours.layoutManager = LinearLayoutManager(this)
        rv_tours.setHasFixedSize(true)
        val testData = createTestData()
        rv_tours.adapter = TourAdapter(testData, { tourItem : TourData -> tourItemClicked(tourItem) })

    }

    private fun tourItemClicked(tourItem : TourData) {
        Toast.makeText(this, "Clicked: ${tourItem.itemName}", Toast.LENGTH_LONG).show()
    }

    private fun createTestData(): List<TourData> {
        val tourList = ArrayList<TourData>()

        tourList.add(TourData("Parks", "Tour Description 1"))
        tourList.add(TourData("Museums", "Tour Description 2"))
        tourList.add(TourData("Landmarks", "Tour Description 3"))
        tourList.add(TourData("Parks", "Tour Description 4"))
        tourList.add(TourData("Must Sees", "Tour Description 5"))
        tourList.add(TourData("Museums", "Tour Description 6"))
        tourList.add(TourData("Landmarks", "Tour Description 7"))
        tourList.add(TourData("Parks", "Tour Description 8"))
        tourList.add(TourData("Museums", "Tour Description 9"))
        tourList.add(TourData("Must Sees ", "Tour Description 10"))
        return tourList
    }



}
