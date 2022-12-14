package com.dilara.vitrinovanew.ui.main.discover.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dilara.vitrinovanew.R
import com.dilara.vitrinovanew.data.model.Featured
import com.dilara.vitrinovanew.utils.GlideUtils

class FeaturedViewPagerAdapter (private var featuredItems: List<Featured>)
    : RecyclerView.Adapter<FeaturedViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView){

        private val imgFeatured: ImageView =itemView.findViewById(R.id.imgFeatured)
        private val textTitle: TextView =itemView.findViewById(R.id.textTitle)
        private val textSubtitle: TextView =itemView.findViewById(R.id.textSubtitle)

        @SuppressLint("SetTextI18n")
        fun bind(featuredItem:Featured){
            GlideUtils.urlToImageView(imgFeatured.context,featuredItem.cover.thumbnail.url,imgFeatured)
            textTitle.text=featuredItem.title
            textSubtitle.text=featuredItem.sub_title
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_featured,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.bind(featuredItems[position])
    }

    override fun getItemCount(): Int {
        return featuredItems.size
    }
    fun updateFeatured(featuredItems: List<Featured>) {
        this.featuredItems = featuredItems
        notifyDataSetChanged()
    }

    fun clearAdapter() {
        this.featuredItems = listOf()
        notifyDataSetChanged()
    }
}