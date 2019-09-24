package host.exp.exponent.custom.RecieptCapture

import android.net.Uri
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import io.realm.Realm
import android.Manifest.permission.CAMERA
import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory

import android.os.Environment
import android.provider.MediaStore
import android.util.Log

import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import java.io.File
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

import host.exp.exponent.R
import host.exp.exponent.custom.utils.*
import host.exp.exponent.custom.CameraActivity
import io.reactivex.disposables.CompositeDisposable


import java.io.ByteArrayOutputStream

private val EXPENSE_ID = "EXPENSE_ID"
class ReceiptCaptureFragment : Fragment() {
    lateinit var imageView: ImageView
    lateinit var captureButton: Button
    private lateinit var realm: Realm

    val REQUEST_IMAGE_CAPTURE = 1
    var uri: Uri? = null

    private val PERMISSION_REQUEST_CODE: Int = 101

    private var mCurrentPhotoPath: String? = null;
    private var expenseId: String? = null



    private lateinit var viewModel: RecieptCaptureViewModel

    companion object {
        @JvmStatic
        fun newInstance(expenseId: String) =
                ReceiptCaptureFragment().apply {
                    arguments = Bundle().apply {
                        putString(EXPENSE_ID, expenseId)
                    }
                }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            expenseId = it.getString(EXPENSE_ID)


        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view =  inflater.inflate(R.layout.reciept_capture_fragment, container, false)
        realm = Realm.getDefaultInstance()
        imageView = view.findViewById(R.id.image_view)
        captureButton = view.findViewById(R.id.btn_capture)
        captureButton.setOnClickListener(View.OnClickListener {
            if (checkPersmission()) takePicture() else requestPermission()
        })
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RecieptCaptureViewModel::class.java)
        expenseId?.let { viewModel.setSelectedExpenseWithId(it)}

        // TODO: Use the ViewModel
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        when (requestCode) {
            PERMISSION_REQUEST_CODE -> {

                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                        && grantResults[1] == PackageManager.PERMISSION_GRANTED) {

                    takePicture()

                } else {
                    //Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
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
                activity!!,
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
            val inputStream = activity!!.getContentResolver().openInputStream(uri)
            val bitmap = BitmapFactory.decodeStream(inputStream)
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.JPEG, 60, stream)
            var byteArray:ByteArray= stream.toByteArray()

            viewModel.insertRecieptDataIntoExpense(byteArray)
            OnReiceptDataDidStoreBus.publish((true))
            /*var expense =  realm.where<Expense>().findFirst()
            Log.d("Expense: ", "${expense.toString()}")
            realm.where(Expense::class.java).findFirst()!!.let {
                storeReciept(it,byteArray)
            }
            Log.d("Expense: ", "Number of persons: ${realm.where<Expense>().count()}")

*/



        }
    }


    private fun checkPersmission(): Boolean {
        return (activity?.let { ContextCompat.checkSelfPermission(it, android.Manifest.permission.CAMERA) } ==
                PackageManager.PERMISSION_GRANTED && ContextCompat.checkSelfPermission(activity!!,
                android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
    }


    private fun requestPermission() {
        activity?.let { ActivityCompat.requestPermissions(it, arrayOf(READ_EXTERNAL_STORAGE, CAMERA), PERMISSION_REQUEST_CODE) }
    }

    @Throws(IOException::class)
    private fun createFile(): File {
        // Create an image file name
        val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
        val storageDir: File = activity!!.getExternalFilesDir(Environment.DIRECTORY_PICTURES)
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
