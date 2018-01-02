package iammert.com.frekans.repository

import iammert.com.frekans.data.local.dao.GenreDao
import iammert.com.frekans.data.local.entity.GenreEntity
import iammert.com.frekans.data.remote.FrekansService
import iammert.com.base.extensions.doIOapplyDatabase
import iammert.com.data.local.dao.RadiosDao
import iammert.com.data.local.dao.RecentlyPlayedDao
import iammert.com.data.local.entity.RadioEntity
import iammert.com.data.local.entity.RecentlyPlayedEntity
import iammert.com.data.remote.model.Radio
import iammert.com.data.util.toRadioEntity
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.util.*
import java.util.concurrent.Callable
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mertsimsek on 12/11/2017.
 */
@Singleton
class RadioRepository @Inject constructor(private val service: FrekansService,
                                          private val radiosDao: RadiosDao,
                                          private val recentlyPlayedDao: RecentlyPlayedDao,
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

    fun addRadioToRecentlyPlayed(radio: Radio): Completable {
        return Single.fromCallable({ radio.toRadioEntity() })
                .doOnSuccess { radiosDao.insertRadio(it) }
                .map { RecentlyPlayedEntity(radioId = it.id) }
                .doOnSuccess { recentlyPlayedDao.insertRecentlyPlayedRadio(it) }
                .subscribeOn(Schedulers.newThread())
                .toCompletable()
    }

    fun getRecentlyPlayedRadio(): Flowable<RadioEntity> {
        return recentlyPlayedDao.getLastRecentlyPlayedRadio()
    }
}