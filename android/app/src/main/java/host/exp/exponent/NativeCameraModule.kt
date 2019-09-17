package host.exp.exponent

import com.facebook.react.bridge.*
import com.facebook.react.uimanager.IllegalViewOperationException
import android.content.Intent
import android.app.Activity
import android.util.Log
import com.facebook.react.bridge.BaseActivityEventListener
import com.facebook.react.bridge.ReactMethod


private val IMAGE_PICKER_REQUEST = 467081
private val E_ACTIVITY_DOES_NOT_EXIST = "E_ACTIVITY_DOES_NOT_EXIST"
private val E_PICKER_CANCELLED = "E_PICKER_CANCELLED"
private val E_FAILED_TO_SHOW_PICKER = "E_FAILED_TO_SHOW_PICKER"
private val E_NO_IMAGE_DATA_FOUND = "E_NO_IMAGE_DATA_FOUND"


class NativeCameraModule(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    var mPromise: Promise? = null

    private val mActivityEventListener = object : BaseActivityEventListener() {

        override fun onActivityResult(activity: Activity?, requestCode: Int, resultCode: Int, intent: Intent?) {

            success("YEAH BOY")

        }
    }

    init {
        reactContext.addActivityEventListener(mActivityEventListener)
    }



    override fun getName(): String {
        return "NativeCameraModule"
    }


    @ReactMethod
    fun sayHi(promise: Promise) {
        mPromise = promise
        val intent = Intent(reactContext, CameraActivity::class.java) // mContext got from your overriden constructor
        currentActivity?.startActivityForResult(intent,0)

       /* try {
            println("Greetings from Java")
            promise.resolve("Callback : Greetings from Java")
        } catch (e: IllegalViewOperationException) {
            promise.resolve(e.toString())
        }*/
    }

    @ReactMethod
    fun success (message: String){
        try {
            mPromise?.resolve(message)
        } catch (e: IllegalViewOperationException) {
            mPromise?.resolve(e.toString())
        }
    }

    @ReactMethod
    fun pickImage(promise: Promise) {
        val currentActivity = currentActivity

        if (currentActivity == null) {
            promise.reject(E_ACTIVITY_DOES_NOT_EXIST, "Activity doesn't exist")
            return
        }
        // Store the promise to resolve/reject when picker returns data
        mPromise = promise

        try {
            val photoIntent = Intent(Intent.ACTION_PICK)
            val intent = Intent(reactContext, CameraActivity::class.java) // mContext got from your overriden constructor

            photoIntent.type = "image/*"

            val chooserIntent = Intent.createChooser(intent, "Take a photo")

            currentActivity.startActivityForResult(chooserIntent, IMAGE_PICKER_REQUEST)
        } catch (e: Exception) {
            mPromise?.reject(E_FAILED_TO_SHOW_PICKER, e)
            mPromise = null
        }

    }


}