package com.codecx.tpackages.data.repo

import android.net.TrafficStats
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
data class NetworkSpeed(
    val rxSpeedBytes: Long,
    val txSpeedBytes: Long
)

class FourGOnlyRepo {

    fun downloadingSpeed(intervalMillis: Long = 1000) : Flow<NetworkSpeed>  = flow{
        var lastRxBytes = TrafficStats.getTotalRxBytes()
        var lastTxBytes = TrafficStats.getTotalTxBytes()
        var lastTime = System.currentTimeMillis()

        while (true) {
            delay(intervalMillis)
            val currentRxBytes = TrafficStats.getTotalRxBytes()
            val currentTxBytes = TrafficStats.getTotalTxBytes()
            val currentTime = System.currentTimeMillis()

            val timeDiff = (currentTime - lastTime) / 1000f
            if (timeDiff > 0) {

                val rxSpeed = if (currentRxBytes != TrafficStats.UNSUPPORTED.toLong() && lastRxBytes != TrafficStats.UNSUPPORTED.toLong()) {
                    ((currentRxBytes - lastRxBytes) / timeDiff).toLong().coerceAtLeast(0)
                } else 0L

                val txSpeed = if (currentTxBytes != TrafficStats.UNSUPPORTED.toLong() && lastTxBytes != TrafficStats.UNSUPPORTED.toLong()) {
                    ((currentTxBytes - lastTxBytes) / timeDiff).toLong().coerceAtLeast(0)
                } else 0L

                emit(NetworkSpeed(rxSpeedBytes = rxSpeed, txSpeedBytes = txSpeed))
            }

            lastRxBytes = currentRxBytes
            lastTxBytes = currentTxBytes
            lastTime = currentTime
        }
    }
}