package com.example.chartdemo

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.widget.TextView
import androidx.core.view.marginBottom
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ViewUtils.dpToPx

class ChartAdapter(private val chartItems: List<ChartItem>) : RecyclerView.Adapter<ChartAdapter.ChartViewHolder>() {

    class ChartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewValueSystolic: TextView = itemView.findViewById(R.id.text_view_thu)
        private val textViewValueDiastolic: TextView = itemView.findViewById(R.id.text_view_truong)
        private var viewBar : View = itemView.findViewById(R.id.view_bar)


        fun bind(item: ChartItem) {
            textViewValueSystolic.text = item.systolicValue.toString()
            textViewValueDiastolic.text = item.diastolicValue.toString()
            val layoutParams = textViewValueSystolic.layoutParams as ViewGroup.MarginLayoutParams
            layoutParams.bottomMargin = item.marginBottom
            textViewValueSystolic.layoutParams = layoutParams

            if (item.diastolicValue >= 200) {
                viewBar.setBackgroundResource(R.drawable.rounded_background_red)
            } else if (item.diastolicValue >= 150) {
                viewBar.setBackgroundResource(R.drawable.rounded_background_light_red)
            } else if (item.diastolicValue >= 120) {
                viewBar.setBackgroundResource(R.drawable.rounded_background)
            } else {
                viewBar.setBackgroundResource(R.drawable.rounded_background_yellow)
            }

            val viewLayoutParams = viewBar.layoutParams
            viewLayoutParams.height = item.viewHeight
            viewBar.layoutParams = viewLayoutParams

            Log.d("hoang", "bind:${textViewValueSystolic.marginBottom.toString()} ")
            Log.d("hoang", "bind:${viewBar.layoutParams.height} ")
            // Customize your chart view here
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChartViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_chart, parent, false)
        return ChartViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ChartViewHolder, position: Int) {
        val chartItem = chartItems[position]
        holder.bind(chartItem)
    }

    override fun getItemCount(): Int = chartItems.size
}
