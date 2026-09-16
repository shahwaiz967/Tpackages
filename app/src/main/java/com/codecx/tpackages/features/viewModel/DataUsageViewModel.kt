package com.codecx.tpackages.features.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codecx.tpackages.data.model.DataUsageModel
import com.codecx.tpackages.data.repo.DataUsageRepo

class DataUsageViewModel(
    private val dataUsageRepo: DataUsageRepo
) : ViewModel() {

    private val _dataUsage = MutableLiveData<List<DataUsageModel>>()
    val dataUsage: LiveData<List<DataUsageModel>> get() = _dataUsage

    fun fetchDataUsage() {
        _dataUsage.value = dataUsageRepo.getLast30DaysUsage()
    }
}
