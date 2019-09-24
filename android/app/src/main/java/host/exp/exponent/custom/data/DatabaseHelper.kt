package host.exp.exponent.custom.data

import host.exp.exponent.custom.data.models.Expense
import io.realm.Realm

class DatabaseHelper {
    private var realm: Realm = Realm.getDefaultInstance()

    fun getExpenseWithId(id: String): Expense {
        var expense = Expense()
        realm.where(Expense::class.java).equalTo("id", id).findFirst().let {
            if (it != null) {
                expense = it
            }
        }
        return expense
    }

    fun insertRecieptDataIntoExpense(expense: Expense, recieptByteArray: ByteArray) {
        realm.executeTransaction {
            expense.receipt = recieptByteArray
        }
    }
    
}