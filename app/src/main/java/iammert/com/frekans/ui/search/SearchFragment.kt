package iammert.com.frekans.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentSearchBinding
import iammert.com.frekans.ui.BaseFragment
import iammert.com.frekans.util.delegates.inflate

/**
 * Created by mertsimsek on 08/11/2017.
 */
class SearchFragment : BaseFragment<SearchViewModel>() {

    private val binding: FragmentSearchBinding by inflate(R.layout.fragment_search)

    override fun getViewModel(): Class<SearchViewModel> {
        return SearchViewModel::class.java
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    companion object {
        fun newInstance() = SearchFragment()
    }
}