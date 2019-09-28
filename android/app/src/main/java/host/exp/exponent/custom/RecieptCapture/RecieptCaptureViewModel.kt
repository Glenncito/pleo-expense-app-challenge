package host.exp.exponent.custom.RecieptCapture

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import host.exp.exponent.custom.data.Repository
import host.exp.exponent.custom.data.models.Expense
import io.reactivex.Flowable
import okhttp3.*
import java.io.File

class RecieptCaptureViewModel (application: Application) : AndroidViewModel(application) {

   private var repository: Repository? = null

    init{
        repository = Repository()
    }


    fun insertRecieptDataIntoExpense(recieptByteArray: ByteArray){
        repository?.insertRecieptDataIntoExpense (recieptByteArray)
    }

    fun uploadReceipt(filePath: String): Flowable<ResponseBody>? {
        val file = File(filePath)
        val fileRequestBody = RequestBody.create(MediaType.parse("image/*"), file)
        val part = MultipartBody.Part.createFormData("upload", file.name, fileRequestBody);
        val description = RequestBody.create (MediaType.parse("text/plain"),"image-type")
        return repository?.uploadReceipt(part, description)


    }

    fun setSelectedExpenseWithId(expenseId: String){
        repository?.setSelectedExpenseWithId(expenseId)
    }



}
