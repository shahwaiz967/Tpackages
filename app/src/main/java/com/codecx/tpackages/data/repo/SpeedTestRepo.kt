package com.codecx.tpackages.data.repo

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

class SpeedTestRepo {

    fun simulateSpeedtest() : Flow<Float> = flow {
        val maxSpeed = Random.nextInt(40, 95).toFloat()
        var current = 0f

        while (current < maxSpeed) {
            current += Random.nextFloat() * 10
            if (current > maxSpeed) current = maxSpeed
            emit(current)
            delay(100)
        }

        repeat(20) {
            val fluctuation = (Random.nextFloat() - 0.5f) * 10
            current = (current + fluctuation).coerceIn(maxSpeed - 15, maxSpeed)
            emit(current)
            delay(100)
        }

        while (current > 0) {
            current -= Random.nextFloat() * 15
            if (current < 0) current = 0f
            emit(current)
            delay(50)
        }
    }
}