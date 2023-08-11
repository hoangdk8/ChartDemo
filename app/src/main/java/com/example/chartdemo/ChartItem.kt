package com.example.chartdemo

import android.os.Parcel
import android.os.Parcelable

data class ChartItem(
    val systolicValue: Float,
    val diastolicValue: Float,
    val marginBottom: Int,
    val viewHeight: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readInt(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeFloat(systolicValue)
        parcel.writeFloat(diastolicValue)
        parcel.writeInt(marginBottom)
        parcel.writeInt(viewHeight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ChartItem> {
        override fun createFromParcel(parcel: Parcel): ChartItem {
            return ChartItem(parcel)
        }

        override fun newArray(size: Int): Array<ChartItem?> {
            return arrayOfNulls(size)
        }
    }
}


