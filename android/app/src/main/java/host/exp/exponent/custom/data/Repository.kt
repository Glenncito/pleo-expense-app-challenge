package host.exp.exponent.custom.data

import android.app.Application
import androidx.lifecycle.LiveData
import host.exp.exponent.custom.data.models.Expense

class Repository() {

    private var database: DatabaseHelper? = null

    init {
        database = DatabaseHelper()
    }

    fun insertRecieptDataIntoExpense(expenseId: String, recieptByteArray: ByteArray){
        database?.insertRecieptDataIntoExpense (expenseId, recieptByteArray)
    }



}