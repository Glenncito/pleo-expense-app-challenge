package host.exp.exponent.models

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class Amount(
        var value: String = "",
        var currency: String = ""
) : RealmObject() {

}