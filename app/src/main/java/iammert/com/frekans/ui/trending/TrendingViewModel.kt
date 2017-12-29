package iammert.com.frekans.ui.trending

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import iammert.com.base.extensions.plusAssign
import iammert.com.data.remote.model.Radio
import iammert.com.frekans.player.PlayerDataSource
import iammert.com.frekans.repository.RadioRepository
import iammert.com.frekans.util.RxAwareViewModel
import iammert.com.player.PlayerState
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by mertsimsek on 11/11/2017.
 */
class TrendingViewModel @Inject constructor(private var radioRepository: RadioRepository) : RxAwareViewModel() {

    private val trendingLiveData = MutableLiveData<List<Radio>>()
    val trendings: LiveData<List<Radio>>
        get() = trendingLiveData

    init {
        disposables += radioRepository.getTrendingRadios()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(trendingLiveData::setValue)
    }

    fun addRadioToRecentlyPlayed(radio: Radio) {
        disposables += radioRepository.addRadioToRecentlyPlayed(radio).subscribe()
    }
}