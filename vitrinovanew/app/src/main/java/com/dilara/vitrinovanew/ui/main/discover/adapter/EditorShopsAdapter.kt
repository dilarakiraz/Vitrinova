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

class EditorShopsAdapter(private var editorShops: List<Shop>)
    : RecyclerView.Adapter<EditorShopsAdapter.EditorShopsViewHolder>() {

    inner class EditorShopsViewHolder(itemView: View)
        :RecyclerView.ViewHolder(itemView){

        private val imgLogo: ImageView =itemView.findViewById(R.id.imgLogo)
        private val textTitle: TextView =itemView.findViewById(R.id.textTitle)
        private val textShop: TextView =itemView.findViewById(R.id.textShop)

        private val imgShop1: ImageView =itemView.findViewById(R.id.imgShop1)
        private val imgShop2: ImageView =itemView.findViewById(R.id.imgShop2)
        private val imgShop3: ImageView =itemView.findViewById(R.id.imgShop3)


        @SuppressLint("SetTextI18n")
        fun bind(editorShop:Shop){
            itemView.animation= AnimationUtils.loadAnimation(itemView.context,R.anim.anim_horizontal_recyclerview)

            textShop.text=editorShop.definition
            textTitle.text=editorShop.name
            editorShop.logo?.let {
                GlideUtils.urlToImageView(imgLogo.context, it.url,imgLogo) }

            GlideUtils.urlToImageView(imgShop1.context,editorShop.popular_products[0].images[0].url,imgShop1)
            GlideUtils.urlToImageView(imgShop2.context,editorShop.popular_products[1].images[0].url,imgShop2)
            GlideUtils.urlToImageView(imgShop3.context,editorShop.popular_products[2].images[0].url,imgShop3)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EditorShopsViewHolder {
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_editor_shops,parent,false)
        return EditorShopsViewHolder(view)
    }

    override fun onBindViewHolder(holder: EditorShopsViewHolder, position: Int) {
        holder.bind(editorShops[position])
    }

    override fun getItemCount(): Int {
        return editorShops.size
    }
    fun updateEditorShops(editorShops: List<Shop>) {
        this.editorShops = editorShops
        notifyDataSetChanged()
    }
}