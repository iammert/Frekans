package iammert.com.data.repository

import iammert.com.frekans.data.local.dao.GenreDao
import iammert.com.frekans.data.local.entity.GenreEntity
import iammert.com.frekans.data.remote.FrekansService
import iammert.com.base.extensions.doIOapplyDatabase
import iammert.com.data.FrekansDatabase
import iammert.com.data.local.dao.RadiosDao
import iammert.com.data.local.dao.RecentlyPlayedDao
import iammert.com.data.local.dao.TrendingDao
import iammert.com.data.local.entity.RadioEntity
import iammert.com.data.local.entity.RecentlyPlayedEntity
import iammert.com.data.util.toGenreEntity
import iammert.com.data.util.toRadioEntity
import iammert.com.data.util.toTrending
import iammert.com.data.util.transaction
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by mertsimsek on 12/11/2017.
 */
@Singleton
class RadioRepository @Inject constructor(private val service: FrekansService,
                                          private val frekansDatabase: FrekansDatabase,
                                          private val radiosDao: RadiosDao,
                                          private val recentlyPlayedDao: RecentlyPlayedDao,
                                          private val genreDao: GenreDao,
                                          private val trendingDao: TrendingDao) {

    /**
     * Get genres from DAO and fetch from
     * remote service and persist it
     */
    fun getGenres(): Flowable<List<GenreEntity>> =
            genreDao.getGenres()
                    .doOnSubscribe {
                        service.getGenres()
                                .toFlowable()
                                .flatMapIterable { it }
                                .map { it.toGenreEntity() }
                                .toList()
                                .doOnSuccess(genreDao::insertGenres)
                                .doIOapplyDatabase()
                                .subscribe()
                    }
                    .subscribeOn(Schedulers.newThread())

    /**
     * Get trending radios from DAO and fetch from
     * remote service and persist it
     */
    fun getTrendingRadios(): Flowable<List<RadioEntity>> =
            trendingDao.getTrendings()
                    .doOnSubscribe({
                        service.getTrending()
                                .toFlowable()
                                .flatMapIterable { it }
                                .map { it.toRadioEntity() }
                                .toList()
                                .doOnSuccess {
                                    frekansDatabase.transaction {
                                        radiosDao.insertRadios(it)
                                        for (item in it) {
                                            trendingDao.insertTrending(item.toTrending())
                                        }
                                    }
                                }
                                .doIOapplyDatabase()
                                .subscribe()
                    })
                    .subscribeOn(Schedulers.newThread())

    /**
     * Add radio to recently played list
     */
    fun addRadioToRecentlyPlayed(radioEntity: RadioEntity): Completable =
            Single.fromCallable({ radioEntity })
                    .doOnSuccess { radiosDao.insertRadio(it) }
                    .map { RecentlyPlayedEntity(radioId = it.id) }
                    .doOnSuccess { recentlyPlayedDao.insertRecentlyPlayedRadio(it) }
                    .subscribeOn(Schedulers.newThread())
                    .toCompletable()

    /**
     * Get last recently played radio from DAO
     */
    fun getRecentlyPlayedRadio(): Flowable<RadioEntity> {
        return recentlyPlayedDao.getLastRecentlyPlayedRadio()
    }

    /**
     * Get all recently played radios from DAO
     */
    fun getRecentlyPlayedRadios(): Flowable<List<RadioEntity>> {
        return recentlyPlayedDao.getRecentlyPlayedRadios()
    }
}