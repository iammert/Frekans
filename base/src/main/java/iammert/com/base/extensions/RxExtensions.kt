package iammert.com.base.extensions

import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by mertsimsek on 22/11/2017.
 */

fun <T> Single<T>.doIOapplyDatabase(): Single<T>{
    return this.subscribeOn(Schedulers.io()).observeOn(Schedulers.single())
}

fun <T> Flowable<T>.doIOapplyDatabase(): Flowable<T>{
    return this.subscribeOn(Schedulers.io()).observeOn(Schedulers.single())
}

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}

