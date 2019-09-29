package host.exp.exponent.custom




import android.app.Activity
import android.content.Intent
import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity

import host.exp.exponent.R
import host.exp.exponent.custom.RecieptCapture.ReceiptCaptureFragment
import host.exp.exponent.custom.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


class CameraActivity : AppCompatActivity() {

    private val EXPENSE_ID = "EXPENSE_ID"

    private var receiptCaptureFragment:ReceiptCaptureFragment? = null
    private var rxSubs = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        initRecieptCapture()


    }

    override fun onResume() {
        super.onResume()
        subscribeOnReceiptDidStoreListener()
    }

    private fun initRecieptCapture(){
        val intent = intent
        val expenseId: String = intent.getStringExtra(EXPENSE_ID)

        receiptCaptureFragment = ReceiptCaptureFragment.newInstance(expenseId)

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentLayout, receiptCaptureFragment!!,"" )
                .addToBackStack(null)
                .commit()
    }

    fun subscribeOnReceiptDidStoreListener(){
        rxSubs.add(
                OnReiceptDataDidStoreBus.listen()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe({
                            if (it!=""){
                                var resultIntent: Intent = Intent()
                                // TODO Add extras or a data URI to this intent as appropriate.
                                resultIntent.putExtra("name", it)
                                this.setResult(Activity.RESULT_OK, resultIntent)
                                finish()
                            }
                        },{

                        })
        )
    }



}

