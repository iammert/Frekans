package iammert.com.frekans.util.extension

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

/**
 * Created by mertsimsek on 22/11/2017.
 */

fun <T> Flowable<T>.doIOapplyMain(): Flowable<T>{
    return this.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
}

fun <T> Flowable<T>.doIOapplyDatabase(): Flowable<T>{
    return this.subscribeOn(Schedulers.io()).observeOn(Schedulers.single())
}

fun <T> Single<T>.doIOapplyDatabase(): Single<T>{
    return this.subscribeOn(Schedulers.io()).observeOn(Schedulers.single())
}

fun <T> Flowable<T>.toLiveData(): LiveData<T>{
    return LiveDataReactiveStreams.fromPublisher(this)
}

operator fun CompositeDisposable.plusAssign(disposable: Disposable) {
    add(disposable)
}

