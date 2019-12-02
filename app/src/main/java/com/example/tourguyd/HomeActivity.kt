package com.example.tourguyd

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    // Access a Cloud Firestore instance from your Activity
    val db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        rv_tours.layoutManager = LinearLayoutManager(this)
        rv_tours.setHasFixedSize(true)
        val testData = createTestData()
        rv_tours.adapter = TourAdapter(testData, { tourItem : TourData -> tourItemClicked(tourItem) })

    }

    private fun tourItemClicked(tourItem : TourData) {
        Toast.makeText(this, "Loading: ${tourItem.itemName}", Toast.LENGTH_LONG).show()
        startActivity(Intent(this,MapActivity::class.java))
    }

    private fun createTestData(): List<TourData> {

        val tourList = ArrayList<TourData>()
        val docRef = db.collection("landmarks").document("description")

        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val cat = document.get("category")?:""
                    val name = document.get("title")?:""

                    //tourList.add(TourData(cat as String, "test"))

                    Log.d("Succeeded", "${document.getString("title")} => ${document.getString("category")}")
                }
            }
            .addOnFailureListener { exception ->
                Log.w("Failed", "Error getting documents.", exception)
            }

        tourList.add(TourData("Landmarks", "Popular Landmarks in the City"))
        tourList.add(TourData("Museums", "Halifax's Most Popular Museums"))
        tourList.add(TourData("Must Sees", "Tourist Hotspots"))
        tourList.add(TourData("Parks", "Enjoy the Beautiful Outdoors"))
        tourList.add(TourData("Must Sees", "All Things Food!"))
        tourList.add(TourData("Must Sees", "Maritime Music!"))
        tourList.add(TourData("Parks", "Get in the Water Harbour Tour"))
        tourList.add(TourData("Museums", "Spooky Ghost Tour"))
        tourList.add(TourData("Must Sees", "Brewery Tours!"))
        tourList.add(TourData("Landmarks", "Tour One Or All Of Our Campuses"))


        return tourList
    }

}
