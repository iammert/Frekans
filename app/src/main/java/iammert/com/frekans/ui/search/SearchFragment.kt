package iammert.com.frekans.ui.search

import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentSearchBinding
import iammert.com.frekans.ui.BaseFragment

/**
 * Created by mertsimsek on 08/11/2017.
 */
class SearchFragment : BaseFragment<SearchViewModel, FragmentSearchBinding>() {

    override fun getViewModel(): Class<SearchViewModel> {
        return SearchViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_search
    }
}