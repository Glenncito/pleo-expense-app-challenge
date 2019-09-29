package host.exp.exponent.custom.data.models

import io.realm.RealmObject
import io.realm.annotations.RealmClass

@RealmClass (name = "user")
open class User(
        var first: String = "",
        var last: String = "",
        var email: String = ""
) : RealmObject() {
}