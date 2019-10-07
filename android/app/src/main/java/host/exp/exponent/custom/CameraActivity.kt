package host.exp.exponent.custom




import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v4.content.FileProvider
import android.support.v7.app.AppCompatActivity

import host.exp.exponent.R
import host.exp.exponent.custom.data.Repository
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

private val EXPENSE_ID = "EXPENSE_ID"
private val PERMISSION_REQUEST_CODE: Int = 101
private val REQUEST_IMAGE_CAPTURE = 1

class CameraActivity : AppCompatActivity() {

    private var uri: Uri? = null
    private var repository: Repository? = null
    private var expenseId: String? = null
    private var mCurrentPhotoPath: String? = null;

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
        expenseId = intent.getStringExtra(EXPENSE_ID)
        if (checkPersmission()) takePicture() else  requestPermission()
    }

    private fun checkPersmission(): Boolean {
        return (this.let { ContextCompat.checkSelfPermission(it, Manifest.permission.CAMERA) } ==
                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
    }

    private fun takePicture() {
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
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

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {
                // If request is cancelled, the result arrays are empty.
                if (!grantResults.isEmpty() || grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                   takePicture()
                }
                return
            }
        }
    }

    @Throws(IOException::class)
    private fun createFile(): File {
        var storageDir: File? = null
       this.getExternalFilesDir(Environment.DIRECTORY_PICTURES).let{
           storageDir = it!!
       }
        return File.createTempFile(
                expenseId,
                ".jpg",
                storageDir
        ).apply {
            mCurrentPhotoPath = absolutePath
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            val resultIntent = Intent()
            resultIntent.putExtra("name", mCurrentPhotoPath)
            this.setResult(RESULT_OK, resultIntent)
            finish()
        } else if (resultCode == RESULT_CANCELED){
            finish()
        }
    }

}

