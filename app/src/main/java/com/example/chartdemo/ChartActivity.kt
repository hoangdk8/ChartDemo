package com.example.chartdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chartdemo.databinding.ActivityChartBinding

class ChartActivity : AppCompatActivity() {
    private lateinit var binding: ActivityChartBinding
    private lateinit var chartAdapter: ChartAdapter
    private val chartItems = mutableListOf<ChartItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        chartAdapter = ChartAdapter(chartItems)
        binding.recyclerViewChart.apply {
            adapter = chartAdapter
            layoutManager = LinearLayoutManager(this@ChartActivity, LinearLayoutManager.HORIZONTAL, false)
        }

        val receivedItems = intent.getParcelableArrayListExtra<ChartItem>("chartItems")
        if (receivedItems != null) {
            chartItems.addAll(receivedItems)
            chartAdapter.notifyDataSetChanged()
        }
    }
}