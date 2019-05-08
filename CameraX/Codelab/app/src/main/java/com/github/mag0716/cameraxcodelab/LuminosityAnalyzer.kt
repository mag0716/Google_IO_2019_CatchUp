package com.github.mag0716.cameraxcodelab

import android.util.Log
import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.github.mag0716.cameraxcodelab.MainActivity.Companion.TAG
import java.nio.ByteBuffer
import java.util.concurrent.TimeUnit

/**
 * 平均輝度を1秒間隔でログ出力する
 */
class LuminosityAnalyzer : ImageAnalysis.Analyzer {

    private var lastAnalyzedTimestamp = 0L

    private fun ByteBuffer.toByteArray(): ByteArray {
        rewind()
        val data = ByteArray(remaining())
        get(data)
        return data
    }

    override fun analyze(image: ImageProxy?, rotationDegrees: Int) {
        if (image == null) {
            return
        }

        val currentTimestamp = System.currentTimeMillis()
        if (currentTimestamp - lastAnalyzedTimestamp >= TimeUnit.SECONDS.toMillis(1)) {
            // YUV
            val buffer = image.planes[0].buffer
            val data = buffer.toByteArray()
            val pixels = data.map { it.toInt() and 0xFF }
            val luma = pixels.average()
            Log.d(TAG, "Average luminosity: $luma")
            lastAnalyzedTimestamp = currentTimestamp
        }
    }
}