package com.example.tourguyd

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.tourguyd.models.TourPost
import kotlinx.android.synthetic.main.layout_tour_list_item.view.*

class TourRecyclerAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private var items: List<TourPost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return TourViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.layout_tour_list_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){

            is TourViewHolder ->{
                holder.bind(items.get(position))
            }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(tourList: List<TourPost>){
        items = tourList
    }

    class TourViewHolder constructor(
        itemView: View
    ): RecyclerView.ViewHolder(itemView){

        val tourImage = itemView.tour_image
        val tourTitle = itemView.tour_title
        val tourCategory = itemView.tour_category

        fun bind(tourPost: TourPost){
            tourTitle.setText(tourPost.title)
            tourCategory.setText(tourPost.category)

            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(tourPost.image)
                .into(tourImage)
        }
    }

}