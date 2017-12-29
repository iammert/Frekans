package iammert.com.frekans.ui.trending

import android.arch.lifecycle.Observer
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iammert.com.data.remote.model.Radio
import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentTrendingBinding
import iammert.com.frekans.ui.BaseFragment
import iammert.com.frekans.util.delegates.inflate
import iammert.com.frekans.util.extension.reObserve

/**
 * Created by mertsimsek on 08/11/2017.
 */
class TrendingFragment : BaseFragment<TrendingViewModel>(), TrendingAdapter.OnItemClickListener {

    private val binding: FragmentTrendingBinding by inflate(R.layout.fragment_trending)

    override fun getViewModel(): Class<TrendingViewModel> {
        return TrendingViewModel::class.java
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.title = getString(R.string.title_trending)

        val adapter = TrendingAdapter()
        adapter.itemClickListener = this
        binding.recyclerView.adapter = adapter
        viewModel.trendings.reObserve(this, Observer { it?.let { adapter.setTrendingList(it) } })
    }

    override fun onItemClicked(radio: Radio) {
        viewModel.addRadioToRecentlyPlayed(radio)
    }

    companion object {
        fun newInstance() = TrendingFragment()
    }
}