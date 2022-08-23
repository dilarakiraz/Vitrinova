package com.dilara.vitrinovanew.ui.main.shops_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dilara.vitrinovanew.R
import com.dilara.vitrinovanew.data.model.Shop
import com.dilara.vitrinovanew.databinding.FragmentShopDetailBinding
import com.dilara.vitrinovanew.ui.main.MainActivity


class ShopDetailFragment(private val toolbarTitle: String,
                         private val shops: List<Shop>) : Fragment(R.layout.fragment_shop_detail) {
    private lateinit var shopsDetailAdapter: ShopsDetailAdapter
    private lateinit var binding:FragmentShopDetailBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentShopDetailBinding.bind(view)

        initView()
        initClick()

    }

    private fun initView() {
        binding.run {
            textTitle.text=toolbarTitle
            shopsDetailAdapter = ShopsDetailAdapter(shops)
            recyclerViewShops.layoutManager = LinearLayoutManager(requireContext(),
                RecyclerView.VERTICAL,false)
            recyclerViewShops.adapter=shopsDetailAdapter
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