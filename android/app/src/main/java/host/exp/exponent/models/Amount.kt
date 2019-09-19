package host.exp.exponent.models

import io.realm.RealmObject

open class Amount(
        var value: String = "",
        var currency: String = ""
) : RealmObject() {

}