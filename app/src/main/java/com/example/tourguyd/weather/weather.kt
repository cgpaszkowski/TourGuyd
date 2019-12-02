package com.example.tourguyd.weather

import android.annotation.SuppressLint
import android.opengl.Visibility
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.tourguyd.R
import android.os.AsyncTask
import android.view.View
import android.widget.ProgressBar
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import org.json.JSONObject
import java.net.URL
import java.text.SimpleDateFormat
import java.util.*

import kotlinx.android.synthetic.main.activity_weather.*
import org.w3c.dom.Text
import java.lang.Exception

class weather : AppCompatActivity() {
    val look : String = findViewById<SearchView>(R.id.cityName).query as String
    val API : String = "4bf4577a95e0d0839ed6ed668e7a2c18"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)

        weatherTask().execute()


    }
    inner class weatherTask(): AsyncTask<String, Void, String>(){


        override fun onPreExecute() {
            super.onPreExecute()
            findViewById<SearchView>(R.id.cityName).visibility = View.VISIBLE
            findViewById<TextView>(R.id.cityName).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.maxTemp).visibility=View.INVISIBLE
            findViewById<TextView>(R.id.minTemp).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.temp).visibility = View.INVISIBLE
            findViewById<TextView>(R.id.weatherDescp).visibility = View.INVISIBLE

        }

        override fun doInBackground(vararg p0: String?): String? {
            var reply : String?

            try{
                //this will search the website for the city given our API
                //we will be using JSON objects to extract the data from the API
                reply = URL ("https://api.openweathermap.org/data/2.5/weather?q=$look&units=metric&appid=$API").readText(Charsets.UTF_8)
            }
            catch(e:Exception){
                reply=null
                e.stackTrace
            }
            return reply
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            try{
                //extracting the JSON objects from the URL
                val jsonObject = JSONObject(result)
                val main = jsonObject.getJSONObject("main")
                val weather = jsonObject.getJSONArray("weather").getJSONObject(0)

                val temp = main.getString("temp")+"°C"
                val tempMin = "Min Temp: " + main.getString("temp_min")+"°C"
                val tempMax = "Max Temp: " + main.getString("temp_max")+"°C"

                val weatherDescp = weather.getString("description")

                //setting the textfields on the display to show the weather
                findViewById<TextView>(R.id.cityName).text = look
                findViewById<TextView>(R.id.maxTemp).text = tempMax
                findViewById<TextView>(R.id.minTemp).text = tempMin
                findViewById<TextView>(R.id.temp).text = temp
                findViewById<TextView>(R.id.weatherDescp).text = weatherDescp.capitalize()

                findViewById<TextView>(R.id.cityName).visibility = View.VISIBLE
                findViewById<TextView>(R.id.maxTemp).visibility=View.VISIBLE
                findViewById<TextView>(R.id.minTemp).visibility = View.VISIBLE
                findViewById<TextView>(R.id.temp).visibility = View.VISIBLE
                findViewById<TextView>(R.id.weatherDescp).visibility = View.VISIBLE

                //user will be able to search again for another city if they so choose


            }catch(e : Exception){
                e.stackTrace
            }
        }


    }

}
