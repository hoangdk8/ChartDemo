package com.example.chartdemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.chartdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val chartItems = mutableListOf<ChartItem>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.buttonDraw.setOnClickListener {
            val intent = Intent(this, ChartActivity::class.java)
            intent.putParcelableArrayListExtra("chartItems", ArrayList(chartItems))
            startActivity(intent)
        }
        binding.buttonAddList.setOnClickListener {
            val systolic = binding.editTextSystolic.text.toString().toFloatOrNull() ?: 0f
            val diastolic = binding.editTextDiastolic.text.toString().toFloatOrNull() ?: 0f
            val marginBottom = (systolic * 3 ).toInt()
            val viewHeight = ((diastolic - systolic)*3-80).toInt()

            chartItems.add(ChartItem(systolic, diastolic, marginBottom, viewHeight))
        }
    }
}