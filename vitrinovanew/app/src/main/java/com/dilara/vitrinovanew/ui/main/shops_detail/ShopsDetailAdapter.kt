package com.dilara.vitrinovanew.ui.main.shops_detail

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

class ShopsDetailAdapter (private var newShops: List<Shop>)
    : RecyclerView.Adapter<ShopsDetailAdapter.ShopsDetailViewHolder>(){

    class ShopsDetailViewHolder(itemView: View)
        :RecyclerView.ViewHolder(itemView){

        private val imgLogo: ImageView =itemView.findViewById(R.id.imgLogo)
        private val imgShop: ImageView =itemView.findViewById(R.id.imgShop)
        private val textTitle: TextView =itemView.findViewById(R.id.textTitle)
        private val textDescription: TextView =itemView.findViewById(R.id.textDescription)
        private val textProductCount: TextView =itemView.findViewById(R.id.textProductCount)

        @SuppressLint("SetTextI18n")
        fun bind(newShop:Shop){
            itemView.animation = AnimationUtils.loadAnimation(itemView.context,R.anim.anim_vertical_recyclerview)

            newShop.logo?.let {
                GlideUtils.urlToImageView(imgLogo.context,it.url,imgLogo)
            }
            newShop.cover?.let {
                GlideUtils.urlToImageView(imgShop.context,it.url,imgShop)
            }
            textTitle.text=newShop.name
            textDescription.text=newShop.definition
            textProductCount.text=newShop.product_count.toString()+" ÜRÜN"

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopsDetailViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_shop_detail,parent,false)
        return ShopsDetailViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopsDetailViewHolder, position: Int) {
        holder.bind(newShops[position])
    }

    override fun getItemCount(): Int {
        return newShops.size
    }

    fun updateShopsDetail(newShops: List<Shop>) {
        this.newShops = newShops
        notifyDataSetChanged()
    }
}