package com.dilara.vitrinovanew.ui.main.discover

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dilara.vitrinovanew.data.model.DiscoverModel
import com.dilara.vitrinovanew.data.repository.VitrinovaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DiscoverViewModel @Inject constructor(
    private val repository: VitrinovaRepository):ViewModel() {

    val postDiscover: MutableLiveData<DiscoverModel> by lazy{
        MutableLiveData<DiscoverModel>()
    }

    fun getDiscover(){
        viewModelScope.launch {
            val retrofitPost=repository.getDiscover()
            retrofitPost.data?.let {
                postDiscover.postValue(retrofitPost.data)
                Log.d("discover is answer",retrofitPost.data.toString())
            }
        }
    }


}