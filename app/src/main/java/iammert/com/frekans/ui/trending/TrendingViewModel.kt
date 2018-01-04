package iammert.com.frekans.ui.trending

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import iammert.com.base.extensions.plusAssign
import iammert.com.data.local.entity.RadioEntity
import iammert.com.data.repository.RadioRepository
import iammert.com.frekans.util.RxAwareViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject

/**
 * Created by mertsimsek on 11/11/2017.
 */
class TrendingViewModel @Inject constructor(private var radioRepository: RadioRepository) : RxAwareViewModel() {

    private val trendingLiveData = MutableLiveData<List<RadioEntity>>()
    val trendings: LiveData<List<RadioEntity>>
        get() = trendingLiveData

    init {
        disposables += radioRepository.getTrendingRadios()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(trendingLiveData::setValue)
    }

    fun addRadioToRecentlyPlayed(radioEntity: RadioEntity) {
        disposables += radioRepository.addRadioToRecentlyPlayed(radioEntity).subscribe()
    }
}