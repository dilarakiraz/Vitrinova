package com.dilara.vitrinovanew.ui.main.collection_detail

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dilara.vitrinovanew.R
import com.dilara.vitrinovanew.data.model.Collections
import com.dilara.vitrinovanew.utils.GlideUtils

class CollectionsDetailAdapter (private var collections:List<Collections>)
    : RecyclerView.Adapter<CollectionsDetailAdapter.CollectionsViewHolder>(){

    inner class CollectionsViewHolder(itemView: View)
        :RecyclerView.ViewHolder(itemView){

        private val imgCollection: ImageView =itemView.findViewById(R.id.imgCollection)
        private val textTitle: TextView =itemView.findViewById(R.id.textTitle)
        private val textDefinition: TextView =itemView.findViewById(R.id.textDefinition)

        @SuppressLint("SetTextI18n")
        fun bind(collection: Collections){
            itemView.animation= AnimationUtils.loadAnimation(itemView.context,R.anim.anim_vertical_recyclerview)

            textTitle.text=collection.title
            textDefinition.text=collection.definition
            GlideUtils.urlToImageView(imgCollection.context,collection.cover.url,imgCollection)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CollectionsViewHolder{
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_collection_detail,parent,false)
        return CollectionsViewHolder(view)
    }

    override fun onBindViewHolder(holder: CollectionsViewHolder, position: Int) {
        holder.bind(collections[position])
    }

    override fun getItemCount(): Int {
        return collections.size
    }
}