package host.exp.exponent.custom.utils

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

object OnReiceptDataDidStoreBus {
    private val publisher = PublishSubject.create<Boolean>()

    fun publish(stored: Boolean){
        publisher.onNext(stored)
    }

    fun listen(): Observable<Boolean> = publisher.hide()
}