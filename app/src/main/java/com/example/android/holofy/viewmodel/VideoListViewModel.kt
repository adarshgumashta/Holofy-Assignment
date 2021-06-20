package com.example.android.holofy.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.holofy.model.Video
import com.example.android.holofy.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VideoListViewModel @Inject constructor(private val repository: Repository) : ViewModel() {
    private val liveData: MutableLiveData<List<Video>> = MutableLiveData()
    fun getLiveData(): MutableLiveData<List<Video>> {
        return liveData
    }

    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            val availableResponse = repository.getData()
            liveData.postValue(availableResponse?.data)
        }
    }
}