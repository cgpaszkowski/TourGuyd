package com.example.tourguyd

import com.example.tourguyd.models.TourPost

class DataSource {

    companion object{

        fun createDataSet(): ArrayList<TourPost>{
            val list = ArrayList<TourPost>()
            list.add(
                TourPost(
                    "Tour Title 1",
                    "Everything about the tour number 1 is briefly described here",
                    "https://raw.githubusercontent.com/mitchabian/Blog-Images/master/digital_ocean.png",
                    "Parks"
                )
            )
            list.add(
                TourPost(
                    "Tour Title 2",
                    "Everything about the tour number 2 is briefly described here",
                    "https://raw.githubusercontent.com/mitchabian/Blog-Images/master/digital_ocean.png",
                    "Museums"
                )
            )
            list.add(
                TourPost(
                    "Tour Title 3",
                    "Everything about the tour number 3 is briefly described here",
                    "https://raw.githubusercontent.com/mitchabian/Blog-Images/master/digital_ocean.png",
                    "Landmarks"
                )
            )
            list.add(
                TourPost(
                    "Tour Title 4",
                    "Everything about the tour number 4 is briefly described here",
                    "https://raw.githubusercontent.com/mitchabian/Blog-Images/master/digital_ocean.png",
                    "Must Sees"
                )
            )
            list.add(
                TourPost(
                    "Tour Title 5",
                    "Everything about the tour number 5 is briefly described here",
                    "https://raw.githubusercontent.com/mitchabian/Blog-Images/master/digital_ocean.png",
                    "Food"
                )
            )
            list.add(
                TourPost(
                    "Tour Title 6",
                    "Everything about the tour number 6 is briefly described here",
                    "https://raw.githubusercontent.com/mitchabian/Blog-Images/master/digital_ocean.png",
                    "Parks"
                )
            )
            return list
        }

    }

}