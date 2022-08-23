package com.dilara.vitrinovanew.ui.main.discover.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dilara.vitrinovanew.R
import com.dilara.vitrinovanew.data.model.Shop
import com.dilara.vitrinovanew.utils.GlideUtils

class NewShopsAdapter(private var newShops: List<Shop>)
    : RecyclerView.Adapter<NewShopsAdapter.NewsShopsViewHolder>() {

    class NewsShopsViewHolder(itemView: View)
        :RecyclerView.ViewHolder(itemView){

        private val textTitle: TextView =itemView.findViewById(R.id.textTitle)
        private val textDescription: TextView =itemView.findViewById(R.id.textDescription)
        private val textProductCount: TextView =itemView.findViewById(R.id.textProductCount)
        private val imgLogo: ImageView =itemView.findViewById(R.id.imgLogo)
        private val imgShop: ImageView =itemView.findViewById(R.id.imgShop)

        @SuppressLint("SetTextI18n")
        fun bind(newShop:Shop){
            itemView.animation= AnimationUtils.loadAnimation(itemView.context,R.anim.anim_horizontal_recyclerview)

            textTitle.text=newShop.name
            textDescription.text=newShop.definition
            textProductCount.text=newShop.product_count.toString()+" ÜRÜN"

            newShop.logo?.let {
                GlideUtils.urlToImageView(imgLogo.context,it.url,imgLogo)
            }
            newShop.cover?.let {
                GlideUtils.urlToImageView(imgShop.context,it.url,imgShop)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsShopsViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_new_shops,parent,false)
        return NewsShopsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsShopsViewHolder, position: Int) {
        holder.bind(newShops[position])
    }

    override fun getItemCount(): Int {
        return newShops.size
    }
    fun updateNewShops(newShops: List<Shop>) {
        this.newShops = newShops
        notifyDataSetChanged()
    }

    fun clearAdapter() {
        this.newShops = listOf()
        notifyDataSetChanged()
    }
}