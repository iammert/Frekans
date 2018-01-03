package iammert.com.frekans.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import iammert.com.frekans.data.local.entity.GenreEntity
import iammert.com.frekans.repository.RadioRepository
import iammert.com.frekans.util.RxAwareViewModel
import iammert.com.base.extensions.plusAssign
import iammert.com.data.local.entity.RadioEntity
import iammert.com.data.local.entity.RecentlyPlayedEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import javax.inject.Inject

/**
 * Created by mertsimsek on 11/11/2017.
 */
class HomeViewModel @Inject constructor(radioRepository: RadioRepository) : RxAwareViewModel() {

    private val genresLiveData = MutableLiveData<List<GenreEntity>>()

    val genres: LiveData<List<GenreEntity>>
        get() = genresLiveData

    private val recentlyPlayedLiveData = MutableLiveData<List<RadioEntity>>()

    val recentlyPlayed: LiveData<List<RadioEntity>>
        get() = recentlyPlayedLiveData

    init {
        disposables += radioRepository.getGenres()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(genresLiveData::setValue)

        disposables += radioRepository
                .getRecentlyPlayedRadios()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(recentlyPlayedLiveData::setValue)

    }
}