package host.exp.exponent




import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.util.Log

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.facebook.react.bridge.ReactApplicationContext
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext
import com.facebook.react.bridge.WritableMap
import com.facebook.react.modules.core.DeviceEventManagerModule
import host.exp.exponent.models.Expense
import host.exp.exponent.utils.ioThread
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where
import java.io.ByteArrayOutputStream


class CameraActivity : AppCompatActivity() {
    lateinit var imageView: ImageView
    lateinit var captureButton: Button
    private lateinit var realm: Realm

    val REQUEST_IMAGE_CAPTURE = 1
    var uri: Uri? = null


    private val PERMISSION_REQUEST_CODE: Int = 101

    private var mCurrentPhotoPath: String? = null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        realm = Realm.getDefaultInstance()
        imageView = findViewById(R.id.image_view)
        captureButton = findViewById(R.id.btn_capture)
        captureButton.setOnClickListener(View.OnClickListener {
            if (checkPersmission()) takePicture() else requestPermission()
        })


    }


    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {

                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                    takePicture()

                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
                return
            }

            else -> {

            }
        }
    }

    private fun takePicture() {

        val intent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val file: File = createFile()

        uri = FileProvider.getUriForFile(
                this,
                "host.exp.exponent.fileprovider.camera",
                file
        )
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            //To get the File for further usage
            /* val auxFile = File(mCurrentPhotoPath)
             var bitmap: Bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath)
             imageView.setImageBitmap(bitmap)*/
            val inputStream = getContentResolver().openInputStream(uri)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 60, stream)
            var byteArray:ByteArray= stream.toByteArray()

            /*var expense =  realm.where<Expense>().findFirst()
            Log.d("Expense: ", "${expense.toString()}")*/
            realm.where(Expense::class.java).findFirst()!!.let {
                storeReciept(it,byteArray)
            }
            Log.d("Expense: ", "Number of persons: ${realm.where<Expense>().count()}")

 getFirstExpense()
randomQuery()

            /*var resultIntent:Intent = Intent()
            // TODO Add extras or a data URI to this intent as appropriate.
            resultIntent.putExtra("some_key", "String data");
            setResult(Activity.RESULT_OK, resultIntent);
            finish()*/

        }
    }

    fun randomQuery(){
        var result: RealmResults<Expense> = realm.where(Expense::class.java).findAll()
        val expense = result[0]

    }
    fun getFirstExpense(){
        realm.where(Expense::class.java).findFirst().let {
            var amount = it?.amount
            Log.d("Amount", "${amount?.value}")
            //return it
        }
    }

    private fun storeReciept(expense: Expense, byteArray: ByteArray){
        realm.executeTransaction {
            expense.receipt = byteArray
        }
    }


    fun sendEvent(context: ReactContext, eventName:String, params: WritableMap) {
        context.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter::class.java).emit(eventName, params)

    }

    private fun checkPersmission(): Boolean {
        return (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CAMERA) ==
                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
    }

    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(READ_EXTERNAL_STORAGE, CAMERA), PERMISSION_REQUEST_CODE)
    }

    @Throws(IOException::class)
    private fun createFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = getExternalFilesDir(Environment.DIRECTORY_PICTURES)
        return File.createTempFile(
                "JPEG_${timeStamp}_", /* prefix */
                ".jpg", /* suffix */
                storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            mCurrentPhotoPath = absolutePath
        }
    }
}

