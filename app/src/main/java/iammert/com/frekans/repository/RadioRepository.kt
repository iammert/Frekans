package iammert.com.frekans.repository

import iammert.com.frekans.data.local.dao.GenreDao
import iammert.com.frekans.data.local.entity.GenreEntity
import iammert.com.frekans.data.remote.FrekansService
import iammert.com.base.extensions.doIOapplyDatabase
import io.reactivex.Flowable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mertsimsek on 12/11/2017.
 */
@Singleton
class RadioRepository @Inject constructor(private val service: FrekansService,
                                          private val genreDao: GenreDao) {


    //TO-DO don't use it like that. I just made it work persistence.
    //TO-DO abstraction will be applied this case and other offline persistence cases.

    fun getGenres(): Flowable<List<GenreEntity>> =
            genreDao.getGenres()
                    .doOnSubscribe {
                        service.getGenres()
                                .toFlowable()
                                .flatMapIterable { it }
                                .map { GenreEntity(it.genreId, it.genreName, it.imageUrl) }
                                .toList()
                                .doOnSuccess(genreDao::insertGenres)
                                .doIOapplyDatabase()
                                .subscribe()
                    }
                    .subscribeOn(Schedulers.single())

    fun getTrendingRadios() = service.getTrending().toFlowable().subscribeOn(Schedulers.io())
}