package host.exp.exponent.custom.data

import android.app.Application
import androidx.lifecycle.LiveData
import host.exp.exponent.custom.data.models.Expense

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


}