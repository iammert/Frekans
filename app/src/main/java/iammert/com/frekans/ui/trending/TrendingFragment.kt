package iammert.com.frekans.ui.trending

import android.arch.lifecycle.Observer
import android.os.Bundle
import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentTrendingBinding
import iammert.com.frekans.ui.BaseFragment
import iammert.com.frekans.util.extension.reObserve

/**
 * Created by mertsimsek on 08/11/2017.
 */
class TrendingFragment : BaseFragment<TrendingViewModel, FragmentTrendingBinding>() {

    override fun getViewModel(): Class<TrendingViewModel> {
        return TrendingViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_trending
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.title = getString(R.string.title_trending)

        val adapter = TrendingAdapter()
        binding.recyclerView.adapter = adapter
        viewModel.getTrendings().reObserve(this, Observer { it?.let { adapter.setTrendingList(it) } })
    }

    companion object {
        fun newInstance() = TrendingFragment()
    }
}