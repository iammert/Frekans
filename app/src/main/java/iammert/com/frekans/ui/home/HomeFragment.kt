package iammert.com.frekans.ui.home

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iammert.com.data.local.entity.RadioEntity
import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentHomeBinding
import iammert.com.frekans.ui.BaseFragment
import iammert.com.frekans.util.delegates.inflate
import iammert.com.frekans.util.extension.reObserve


/**
 * Created by mertsimsek on 08/11/2017.
 */
class HomeFragment : BaseFragment<HomeViewModel>(), RecentlyPlayedAdapter.OnItemClickListener {

    private val binding: FragmentHomeBinding by inflate(R.layout.fragment_home)

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.title = getString(R.string.title_homepage)

        val genreAdapter = GenresAdapter()
        binding.recyclerviewGenres.adapter = genreAdapter
        viewModel.genresLiveData.reObserve(this, Observer {
            it?.let { genreAdapter.setGenres(it) }
        })

        val recentlyPlayedAdapter = RecentlyPlayedAdapter()
        recentlyPlayedAdapter.setOnItemClickListener(this)
        binding.recyclerviewRecentlyPlayed.adapter = recentlyPlayedAdapter
        viewModel.recentlyPlayed.reObserve(this, Observer {
            it?.let { recentlyPlayedAdapter.setRecentlyPlayedRadios(it) }
        })
    }

    override fun onItemClicked(radioEntity: RadioEntity) {
        viewModel.addRadioToRecentlyPlayed(radioEntity)
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}