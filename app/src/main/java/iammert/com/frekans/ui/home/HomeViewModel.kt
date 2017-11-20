package iammert.com.frekans.ui.home

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.LiveDataReactiveStreams
import android.arch.lifecycle.ViewModel
import iammert.com.frekans.data.RadioRepository
import iammert.com.frekans.data.remote.model.Genre
import javax.inject.Inject

/**
 * Created by mertsimsek on 11/11/2017.
 */
class HomeViewModel @Inject constructor(radioRepository: RadioRepository) : ViewModel() {
    private val genresLiveData = LiveDataReactiveStreams.fromPublisher(radioRepository.getGenres())

    fun getGenres(): LiveData<List<Genre>> = genresLiveData
}