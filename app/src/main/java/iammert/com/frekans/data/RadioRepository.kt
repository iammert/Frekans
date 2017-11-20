package iammert.com.frekans.data

import iammert.com.frekans.data.local.dao.GenreDao
import iammert.com.frekans.data.remote.FrekansService
import iammert.com.frekans.data.remote.model.Genre
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mertsimsek on 12/11/2017.
 */
@Singleton
class RadioRepository @Inject constructor(private val service: FrekansService,
                                          private val genreDao: GenreDao) {

    fun getGenres(): Flowable<List<Genre>> = service.getGenres()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .toFlowable()
}