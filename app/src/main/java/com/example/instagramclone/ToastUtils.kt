package com.example.instagramclone

import android.content.Context
import android.widget.Toast

/**
 * Extension function to show a Toast
 * @param text string to be showed in the Toast
 * @param duration Duration of the toast in the screen, can be [Toast.LENGTH_SHORT] or [Toast.LENGTH_LONG]
 *
 * In kotlin we can define default values to the received parameters, in this case duration
 * has as default value [Toast.LENGTH_SHORT]
 */
fun Context.showToast(text: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, duration).show()
}