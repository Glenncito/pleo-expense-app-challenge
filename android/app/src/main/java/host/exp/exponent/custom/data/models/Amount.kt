package host.exp.exponent.custom.data.models

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass (name = "amount")
open class Amount(
        var value: String = "",
        var currency: String = ""
) : RealmObject() {

}