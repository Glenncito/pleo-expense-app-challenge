package host.exp.exponent.models



import io.realm.RealmObject
import java.util.*

open class Expense(
        var date: Date = Date(),
        var merchant: String = "",
        var amount: Amount? = null,
        var user: User? = null,
        var receipt: ByteArray? = null
) : RealmObject() {


}