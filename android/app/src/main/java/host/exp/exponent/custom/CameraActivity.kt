package host.exp.exponent.custom




import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider

import host.exp.exponent.R
import host.exp.exponent.custom.RecieptCapture.ReceiptCaptureFragment
import host.exp.exponent.custom.data.Repository
import host.exp.exponent.custom.utils.*
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

private val EXPENSE_ID = "EXPENSE_ID"
private val PERMISSION_REQUEST_CODE: Int = 101
private val REQUEST_IMAGE_CAPTURE = 1
class CameraActivity : AppCompatActivity() {

    var uri: Uri? = null
    private var repository: Repository? = null


    private var mCurrentPhotoPath: String? = null;
    private var expenseId: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)
        initRecieptCapture()
        repository = Repository()


    }

    override fun onBackPressed() {
        finish()
    }

    private fun initRecieptCapture(){
        val intent = intent
        val expenseId: String = intent.getStringExtra(EXPENSE_ID)

        if (checkPersmission()) takePicture() else requestPermission()
        /*
        receiptCaptureFragment = ReceiptCaptureFragment.newInstance(expenseId)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentLayout, receiptCaptureFragment!!,"" )
                .commit()*/
    }

    private fun checkPersmission(): Boolean {
        return (this.let { ContextCompat.checkSelfPermission(it, Manifest.permission.CAMERA) } ==
                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
    }

    private fun takePicture() {

        val intent: Intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        val file: File = createFile()

        uri = FileProvider.getUriForFile(
               this ,
                "host.exp.exponent.fileprovider.camera",
                file
        )
        intent.putExtra(MediaStore.EXTRA_OUTPUT, uri)
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE)

    }

    private fun requestPermission() {
        this.let { ActivityCompat.requestPermissions(it, arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.CAMERA), PERMISSION_REQUEST_CODE) }
    }

    @Throws(IOException::class)
    private fun createFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        var storageDir: File? = null
       this.getExternalFilesDir(Environment.DIRECTORY_PICTURES).let{
           storageDir = it!!
       }
        return File.createTempFile(
                "JPEG_${timeStamp}_", /* prefix */
                ".jpg", /* suffix */
                storageDir /* directory */
        ).apply {
            // Save a file: path for use with ACTION_VIEW intents
            mCurrentPhotoPath = absolutePath
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            var resultIntent: Intent = Intent()
            resultIntent.putExtra("name", mCurrentPhotoPath)
            this.setResult(Activity.RESULT_OK, resultIntent)
            finish()
        } else if (resultCode == Activity.RESULT_CANCELED){
            finish()
        }
    }


    fun insertRecieptDataIntoExpense(){
        val inputStream = this.getContentResolver().openInputStream(uri)
        val bitmap = BitmapFactory.decodeStream(inputStream)
        val stream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.JPEG, 60, stream)
        var byteArray:ByteArray= stream.toByteArray()
       // expenseId?.let { repository?.insertRecieptDataIntoExpense (it,byteArray) }
    }


}

