package iammert.com.frekans.ui.home

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.util.Log
import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentHomeBinding
import iammert.com.frekans.ui.BaseFragment


/**
 * Created by mertsimsek on 08/11/2017.
 */
class HomeFragment : BaseFragment<HomeViewModel, FragmentHomeBinding>() {

    override fun getViewModel(): Class<HomeViewModel> {
        return HomeViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_home
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.title = getString(R.string.title_homepage)

        val genreAdapter = GenresAdapter()
        binding.recyclerView.adapter = genreAdapter

        viewModel.getGenres().observe(this, Observer {
            it?.let { genreAdapter.setGenres(it) }
        })
    }

    companion object {
        fun newInstance() = HomeFragment()
    }
}