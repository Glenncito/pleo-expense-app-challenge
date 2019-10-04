package host.exp.exponent.custom.RecieptCapture

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import host.exp.exponent.custom.data.Repository
import host.exp.exponent.custom.data.models.Expense

class RecieptCaptureViewModel (application: Application) : AndroidViewModel(application) {

   private var repository: Repository? = null

    init{
        repository = Repository()
    }


    fun insertRecieptDataIntoExpense(recieptByteArray: ByteArray){
        repository?.insertRecieptDataIntoExpense ("",recieptByteArray)
    }



}