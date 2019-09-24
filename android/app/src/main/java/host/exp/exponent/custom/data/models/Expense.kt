package host.exp.exponent.custom.data.models



import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass
open class Expense(
        @PrimaryKey
        var id: String = "",
        var date: Date = Date(),
        var merchant: String = "",
        var amount: Amount? = null,
        var user: User? = null,
        var receipt: ByteArray? = null
) : RealmObject() {


}