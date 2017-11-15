package iammert.com.frekans.ui.trending

import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentTrendingBinding
import iammert.com.frekans.ui.BaseFragment

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

    companion object {
        fun newInstance() = TrendingFragment()
    }
}