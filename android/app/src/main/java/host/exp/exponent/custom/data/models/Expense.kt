package host.exp.exponent.custom.data.models



import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass
import java.util.*

@RealmClass (name = "expense")
open class Expense(
        @PrimaryKey
        var id: String = "",
        var date: String = "",
        var merchant: String = "",
        var amount: Amount? = null,
        var category: String = "",
        var comment: String = "",
        var user: User? = null,
        var receipt: ByteArray? = null,
        var index: Int = 0
) : RealmObject() {


}