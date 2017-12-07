package iammert.com.frekans.ui.home

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentHomeBinding
import iammert.com.frekans.ui.BaseFragment
import iammert.com.frekans.util.delegates.inflate
import iammert.com.frekans.util.extension.reObserve


/**
 * Created by mertsimsek on 08/11/2017.
 */
class HomeFragment : BaseFragment<HomeViewModel>() {

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
        binding.recyclerView.adapter = genreAdapter

        viewModel.genres.reObserve(this, Observer {
            it?.let { genreAdapter.setGenres(it) }
        })
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}