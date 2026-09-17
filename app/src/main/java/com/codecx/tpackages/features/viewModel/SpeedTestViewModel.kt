package com.codecx.tpackages.features.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codecx.tpackages.data.repo.SpeedTestRepo
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SpeedTestViewModel(
    private val netSpeedRepo: SpeedTestRepo
) : ViewModel() {

    private val _downloadSpeed = MutableLiveData<Float>(0f)
    val downloadSpeed: LiveData<Float> = _downloadSpeed

    private val _uploadSpeed = MutableLiveData<Float>(0f)
    val uploadSpeed: LiveData<Float> = _uploadSpeed

    private val _currentSpeed = MutableLiveData<Float>(0f)
    val currentSpeed: LiveData<Float> = _currentSpeed

    private val _isTesting = MutableLiveData<Boolean>(false)
    val isTesting: LiveData<Boolean> = _isTesting

    fun startSpeedTest() {
        if (_isTesting.value == true) return

        viewModelScope.launch {
            _isTesting.value = true
            
            _downloadSpeed.value = 0f
            _uploadSpeed.value = 0f

            var maxDownload = 0f
            netSpeedRepo.simulateSpeedtest().collect { speed ->
                if (speed > maxDownload) {
                    maxDownload = speed
                    _downloadSpeed.value = speed
                }
                _currentSpeed.value = speed
            }

            delay(3000L)

            var maxUpload = 0f
            netSpeedRepo.simulateSpeedtest().collect { speed ->
                if (speed > maxUpload) {
                    maxUpload = speed
                    _uploadSpeed.value = speed
                }
                _currentSpeed.value = speed
            }

            _isTesting.value = false
            _currentSpeed.value = 0f
        }
    }


}
