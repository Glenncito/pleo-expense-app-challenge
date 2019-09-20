package host.exp.exponent.models

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass
open class User(
        var first: String = "",
        var last: String = "",
        var email: String = ""
) : RealmObject() {
}