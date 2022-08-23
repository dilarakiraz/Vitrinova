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
import com.dilara.vitrinovanew.data.model.Category
import com.dilara.vitrinovanew.utils.GlideUtils

class CategoriesAdapter(private var categories:List<Category>)
    : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    class CategoriesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {

        private val imgCategory: ImageView =itemView.findViewById(R.id.imgCategory)
        private val textCategory: TextView =itemView.findViewById(R.id.textCategory)

        @SuppressLint("SetTextI18n")
        fun bind(category: Category) {
            itemView.animation= AnimationUtils.loadAnimation(itemView.context,R.anim.anim_horizontal_recyclerview)

            textCategory.text=category.name
            category.cover?.let {
                GlideUtils.urlToImageView(imgCategory.context,it.url,imgCategory)
            }


        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder{
        val view= LayoutInflater.from(parent.context)
            .inflate(R.layout.item_categories,parent,false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        holder.bind(categories[position])
    }

    override fun getItemCount(): Int {
        return categories.size
    }

    fun updateCategories(categories: List<Category>) {
        this.categories = categories
        notifyDataSetChanged()
    }
}