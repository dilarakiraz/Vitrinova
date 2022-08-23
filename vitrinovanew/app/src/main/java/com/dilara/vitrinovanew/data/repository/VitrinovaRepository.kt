package com.dilara.vitrinovanew.data.repository

import com.dilara.vitrinovanew.data.model.DiscoverModel
import com.dilara.vitrinovanew.data.remote.Resource
import com.dilara.vitrinovanew.data.remote.ServiceClientInstance
import com.dilara.vitrinovanew.utils.Utils.safeApiCall

class VitrinovaRepository() {
    suspend fun getDiscover(): Resource<DiscoverModel> {

        return safeApiCall(call = { ServiceClientInstance.getInstance().api.getDiscover() })
    }
}