package com.dilara.vitrinovanew.ui.main.collection_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dilara.vitrinovanew.R
import com.dilara.vitrinovanew.data.model.Collections
import com.dilara.vitrinovanew.databinding.FragmentCollectionsDetailBinding
import com.dilara.vitrinovanew.ui.main.MainActivity


class CollectionsDetailFragment (private var toolbarTitle:String,
                                 private val collections:List<Collections>):Fragment(R.layout.fragment_collections_detail){

    private lateinit var collectionsDetailAdapter: CollectionsDetailAdapter
    private lateinit var binding: FragmentCollectionsDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentCollectionsDetailBinding.bind(view)

        view.animation= AnimationUtils.loadAnimation(requireContext(),R.anim.anim_vertical_recyclerview)

        initView()
        initClick()
    }

    private fun initView(){
        binding.run {
            textTitle.text=toolbarTitle
            collectionsDetailAdapter=CollectionsDetailAdapter(collections)
            recyclerViewCollections.layoutManager= LinearLayoutManager(requireContext(),
                RecyclerView.VERTICAL,false)
            recyclerViewCollections.adapter=collectionsDetailAdapter
        }
    }
    private fun initClick(){
        binding.run {
            btnBack.setOnClickListener {
                (activity as MainActivity).onBackPressed()
            }
        }
    }


}