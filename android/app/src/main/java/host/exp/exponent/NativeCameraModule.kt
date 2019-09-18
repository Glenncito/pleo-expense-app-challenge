package host.exp.exponent

import com.facebook.react.bridge.*
import com.facebook.react.uimanager.IllegalViewOperationException
import android.content.Intent
import android.app.Activity
import android.util.Log
import com.facebook.react.bridge.BaseActivityEventListener
import com.facebook.react.bridge.ReactMethod
import io.realm.Realm
import io.realm.RealmObject
import java.util.*
import io.realm.RealmResults


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

        initRealm()


    }

    private fun initRealm() {
        Realm.init(reactContext)

// Get a Realm instance for this thread
        val realm = Realm.getDefaultInstance()
        success("Realm Init")
        realm.where(Expense::class.java).findFirst()!!.let {
            var amount = it.amount
            Log.d("Amount", "${amount?.value}")
        }
    }

    override fun getName(): String {
        return "NativeCameraModule"
    }


    @ReactMethod
    fun sayHi(promise: Promise) {
        mPromise = promise
        val intent = Intent(reactContext, CameraActivity::class.java) // mContext got from your overriden constructor
        currentActivity?.startActivityForResult(intent, 0)

        /* try {
             println("Greetings from Java")
             promise.resolve("Callback : Greetings from Java")
         } catch (e: IllegalViewOperationException) {
             promise.resolve(e.toString())
         }*/
    }

    @ReactMethod
    fun success(message: String) {
        try {
            mPromise?.resolve(message)
        } catch (e: IllegalViewOperationException) {
            mPromise?.resolve(e.toString())
        }
    }
}

open class Expense(
    var date: Date = Date(),
    var merchant: String = "",
    var amount: Amount? = null,
    var user: User? = null
) : RealmObject() {


}

open class Amount(
        var value: String = "",
        var currency: String = ""
) : RealmObject() {

}

open class User(
        var first: String = "",
        var last: String = "",
        var email: String = ""
) : RealmObject() {
}
