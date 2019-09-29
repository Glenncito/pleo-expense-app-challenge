package host.exp.exponent.custom.utils

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

object OnReiceptDataDidStoreBus {
    private val publisher = PublishSubject.create<String>()

    fun publish(stored: String){
        publisher.onNext(stored)
    }

    fun listen(): Observable<String> = publisher.hide()
}