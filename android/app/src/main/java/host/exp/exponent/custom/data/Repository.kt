package host.exp.exponent.custom.data



class Repository() {

    private var database: DatabaseHelper? = null

    init {
        database = DatabaseHelper()
    }

    fun insertRecieptDataIntoExpense(expenseId: String, recieptByteArray: ByteArray){
        database?.insertRecieptDataIntoExpense (expenseId, recieptByteArray)
    }



}