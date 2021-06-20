package com.example.android.holofy.repository

import com.example.android.holofy.model.Category
import com.example.android.holofy.network.ApiClient
import javax.inject.Inject

class Repository @Inject constructor(private val apiClient: ApiClient) {
    suspend fun getData(): Category {
        return apiClient.getData()
    }
}