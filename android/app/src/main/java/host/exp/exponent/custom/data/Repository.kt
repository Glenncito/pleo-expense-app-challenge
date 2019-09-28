package host.exp.exponent.custom.data

import android.app.Application
import androidx.lifecycle.LiveData
import host.exp.exponent.custom.api.ApiClient
import host.exp.exponent.custom.data.models.Expense
import io.reactivex.Flowable
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.Response
import okhttp3.ResponseBody

class Repository() {
    private var expense: Expense? = null

    private var database: DatabaseHelper? = null

    init {
        database = DatabaseHelper()
    }

    fun insertRecieptDataIntoExpense(recieptByteArray: ByteArray){
        database?.insertRecieptDataIntoExpense (expense!!, recieptByteArray)
    }

    fun setSelectedExpenseWithId(expenseId: String){
        expense = database?.getExpenseWithId(expenseId)
    }

    fun uploadReceipt(file: MultipartBody.Part, description: RequestBody): Flowable<ResponseBody> {
        return ApiClient.getInstance().uploadReceipt(expense!!.id, file, description)
    }


}