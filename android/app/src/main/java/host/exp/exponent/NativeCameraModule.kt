package host.exp.exponent

import com.facebook.react.bridge.*
import com.facebook.react.uimanager.IllegalViewOperationException


class NativeCameraModule(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String {
        return "NativeCameraModule"
    }

    override fun canOverrideExistingModule(): Boolean {
        return true
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