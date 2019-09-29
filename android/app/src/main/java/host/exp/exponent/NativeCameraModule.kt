package host.exp.exponent

import com.facebook.react.bridge.*
import com.facebook.react.uimanager.IllegalViewOperationException
import android.content.Intent
import android.app.Activity
import com.facebook.react.bridge.BaseActivityEventListener
import com.facebook.react.bridge.ReactMethod
import host.exp.exponent.custom.CameraActivity
import io.realm.Realm
import io.realm.RealmConfiguration





private val EXPENSE_ID = "EXPENSE_ID"


class NativeCameraModule(private val reactContext: ReactApplicationContext) : ReactContextBaseJavaModule(reactContext) {

    var mPromise: Promise? = null

    private val mActivityEventListener = object : BaseActivityEventListener() {

        override fun onActivityResult(activity: Activity?, requestCode: Int, resultCode: Int, intent: Intent?) {

            success(intent!!.getStringExtra("name"))

        }
    }

    init {
        reactContext.addActivityEventListener(mActivityEventListener)

        initRealm()


    }

    private fun initRealm() {
        Realm.init(reactContext)
        val mRealmConfiguration = RealmConfiguration.Builder()
                .name("default.realm")
                .inMemory()
                .build()

        Realm.getInstance(mRealmConfiguration)
        Realm.setDefaultConfiguration(mRealmConfiguration)

// Get a Realm instance for this thread

    }

    override fun getName(): String {
        return "NativeCameraModule"
    }


    @ReactMethod
        fun initReceiptCapture(expenseId:String, promise: Promise) {
        mPromise = promise
        var intent = Intent(reactContext, CameraActivity::class.java) // mContext got from your overriden constructor
        intent.putExtra(EXPENSE_ID,expenseId)
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
/*
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
 */