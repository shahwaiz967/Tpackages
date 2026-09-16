package com.codecx.tpackages.features.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codecx.tpackages.data.repo.FourGOnlyRepo
import com.codecx.tpackages.data.utils.formatFileSize
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

data class SpeedUiState(
    val incomingSpeed: String = "0 B/s",
    val outgoingSpeed: String = "0 B/s",
    val totalSpeedFormatted: String? = null,
    val isMonitoring: Boolean = false
)

class FourGOnlyViewModel(
    private val repo : FourGOnlyRepo
) : ViewModel() {
    private val _uiState = MutableStateFlow(SpeedUiState())
    val uiState: StateFlow<SpeedUiState> = _uiState.asStateFlow()

    private var speedMonitoringJob: Job? = null

    fun toggleOrStartMonitoring() {
        if (speedMonitoringJob?.isActive == true) {
            speedMonitoringJob?.cancel()
            _uiState.value = SpeedUiState(isMonitoring = false)
            return
        }

        _uiState.value = _uiState.value.copy(isMonitoring = true)

        speedMonitoringJob = viewModelScope.launch {
            repo.downloadingSpeed().collect { speed ->
                val rxFormatted = "${speed.rxSpeedBytes.formatFileSize()}/s"
                val txFormatted = "${speed.txSpeedBytes.formatFileSize()}/s"
                val totalBytes = speed.rxSpeedBytes + speed.txSpeedBytes

                val totalFormatted = totalBytes.formatFileSize().replace(" ", "\n")

                _uiState.value = SpeedUiState(
                    incomingSpeed = rxFormatted,
                    outgoingSpeed = txFormatted,
                    totalSpeedFormatted = totalFormatted,
                    isMonitoring = true
                )
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        speedMonitoringJob?.cancel()
    }
}