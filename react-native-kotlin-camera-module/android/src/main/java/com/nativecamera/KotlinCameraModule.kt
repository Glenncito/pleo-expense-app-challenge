package com.nativecamera

import com.facebook.react.bridge.*
import com.facebook.react.uimanager.IllegalViewOperationException


class KotlinCameraModule(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "KotlinCameraModule"
    }

    @ReactMethod
    fun sayHi(promise: Promise) {
        try {
            println("Greetings from Java")
          promise.resolve("Callback : Greetings from Java")
        } catch (e: IllegalViewOperationException) {
            promise.resolve(e.toString())
        }
    }
}
