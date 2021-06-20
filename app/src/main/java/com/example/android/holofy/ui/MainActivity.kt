package com.example.android.holofy.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android.holofy.VideoListAdapter
import com.example.android.holofy.databinding.ActivityMainBinding
import com.example.android.holofy.model.Video
import com.example.android.holofy.viewmodel.VideoListViewModel
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    private lateinit var arrayList: ArrayList<Video>
    private lateinit var activityMainAdapter: VideoListAdapter
    private val videoListViewModel: VideoListViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)
        arrayList = ArrayList<Video>()
        activityMainBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = activityMainAdapter
        }
        videoListViewModel.getData()
        videoListViewModel.getLiveData().observe(
            this,
            object : Observer<List<Video>> {
                override fun onChanged(t: List<Video>?) {
                    if (t != null) {
                        arrayList.addAll(t)
                        activityMainAdapter.notifyDataSetChanged()
                    }
                    t?.forEachIndexed { index, video ->
                        Log.d(video.description, index.toString())
                    }
                }
            })
    }
}