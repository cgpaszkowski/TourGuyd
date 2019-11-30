package com.example.tourguyd

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.tour_list_item.view.*

class TourAdapter (val tourItemList: List<TourData>, val clickListener: (TourData) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        // LayoutInflater: takes ID from layout defined in XML.
        // Instantiates the layout XML into corresponding View objects.
        // Use context from main app -> also supplies theme layout values!
        val inflater = LayoutInflater.from(parent.context)
        // Inflate XML. Last parameter: don't immediately attach new view to the parent view group
        val view = inflater.inflate(R.layout.tour_list_item, parent, false)
        return tourViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        // Populate ViewHolder with data that corresponds to the position in the list
        // which we are told to load
        (holder as tourViewHolder).bind(tourItemList[position], clickListener)
    }

    override fun getItemCount() = tourItemList.size

    class tourViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(tour: TourData, clickListener: (TourData) -> Unit) {
            itemView.tv_part_item_name.text = tour.itemName
            itemView.tv_part_id.text = tour.category.toString()
            itemView.setOnClickListener { clickListener(tour) }
        }
    }
}