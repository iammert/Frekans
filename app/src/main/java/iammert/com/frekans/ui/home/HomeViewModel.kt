package iammert.com.frekans.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import iammert.com.frekans.data.RadioRepository
import iammert.com.frekans.data.local.entity.GenreEntity
import iammert.com.frekans.util.RxAwareViewModel
import iammert.com.frekans.util.extension.plusAssign
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by mertsimsek on 11/11/2017.
 */
class HomeViewModel @Inject constructor(radioRepository: RadioRepository) : RxAwareViewModel() {

    private val genresLiveData = MutableLiveData<List<GenreEntity>>()

    init {
        disposables += radioRepository.getGenres()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(genresLiveData::setValue)
    }

    fun getGenres(): LiveData<List<GenreEntity>> = genresLiveData
}