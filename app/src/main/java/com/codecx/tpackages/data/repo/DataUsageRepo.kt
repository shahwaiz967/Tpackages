package com.codecx.tpackages.data.repo

import com.codecx.tpackages.data.model.DataUsageModel
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class DataUsageRepo {
    fun getDataUsageList(): List<DataUsageModel> {

        val dataList = mutableListOf<DataUsageModel>()
        val calendar = Calendar.getInstance()
        val sdf = SimpleDateFormat("MMM dd,yyyy", Locale.getDefault())

        for (i in 0 until 60) {
            val date = sdf.format(calendar.time)
            dataList.add(
                DataUsageModel(
                    date = date,
                    mobileData = (100..500).random(),
                    wifiData = (500..2000).random()
                )
            )
            calendar.add(Calendar.DAY_OF_YEAR, -1)
        }
        return dataList
    }

    fun getLast30DaysUsage(): List<DataUsageModel>{
        val allData = getDataUsageList()
        val sdf = SimpleDateFormat("MMM dd,yyyy", Locale.getDefault())
        val thirtyDaysAgo = Calendar.getInstance().apply {
            add(Calendar.DAY_OF_YEAR, -30)
        }.time
        return allData.filter {
            try {
                val itemDate = sdf.parse(it.date)
                itemDate != null && itemDate.after(thirtyDaysAgo)
            } catch (_: Exception) {
                false
            }
        }
    }

}
