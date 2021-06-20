package com.example.android.holofy.network

import com.example.android.holofy.model.Category
import javax.inject.Inject

class ApiClient @Inject constructor(private val apiService: ApiService) {
    suspend fun getData(): Category {
        return apiService.getData()
    }
}