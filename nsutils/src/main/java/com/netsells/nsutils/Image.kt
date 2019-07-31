package com.netsells.nsutils

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Matrix
import android.media.ThumbnailUtils
import androidx.exifinterface.media.ExifInterface
import kotlin.math.min

/**
 * Transforms the image at [filePath] into a square, center-cropped version of the specified [size].
 *
 * This will also correct any rotation issues.
 */
fun createThumbnail(filePath: String, size: Int = 512): Bitmap {
    val exif = ExifInterface(filePath)
    val orientation =
        exif.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_UNDEFINED)
    val b = BitmapFactory.decodeFile(filePath)
    val smallestSide = min(b.width, b.height)
    val centerCrop = ThumbnailUtils.extractThumbnail(b, smallestSide, smallestSide)

    val bitmap = Bitmap.createScaledBitmap(centerCrop, size, size, false).rotate(orientation)!!

    b.recycle()
    centerCrop.recycle()

    return bitmap
}

private fun Bitmap.rotate(orientation: Int): Bitmap? {
    val matrix = Matrix()
    when (orientation) {
        ExifInterface.ORIENTATION_FLIP_HORIZONTAL -> matrix.setScale(-1f, 1f)
        ExifInterface.ORIENTATION_ROTATE_180 -> matrix.setRotate(180f)
        ExifInterface.ORIENTATION_FLIP_VERTICAL -> {
            matrix.setRotate(180f)
            matrix.postScale(-1f, 1f)
        }
        ExifInterface.ORIENTATION_TRANSPOSE -> {
            matrix.setRotate(90f)
            matrix.postScale(-1f, 1f)
        }
        ExifInterface.ORIENTATION_ROTATE_90 -> matrix.setRotate(90f)
        ExifInterface.ORIENTATION_TRANSVERSE -> {
            matrix.setRotate(-90f)
            matrix.postScale(-1f, 1f)
        }
        ExifInterface.ORIENTATION_ROTATE_270 -> {
            matrix.setRotate(-90f)
        }
        else -> return this
    }
    return try {
        val rotated = Bitmap.createBitmap(this, 0, 0, width, height, matrix, true)
        this.recycle()
        rotated
    } catch (e: OutOfMemoryError) {
        e.printStackTrace()
        null
    }
}