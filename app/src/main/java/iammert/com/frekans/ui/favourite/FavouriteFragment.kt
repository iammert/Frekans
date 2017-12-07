package iammert.com.frekans.ui.favourite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentFavouriteBinding
import iammert.com.frekans.ui.BaseFragment
import iammert.com.frekans.util.delegates.inflate

/**
 * Created by mertsimsek on 08/11/2017.
 */
class FavouriteFragment : BaseFragment<FavouriteViewModel>() {

    private val binding: FragmentFavouriteBinding by inflate(R.layout.fragment_favourite)

    override fun getViewModel(): Class<FavouriteViewModel> {
        return FavouriteViewModel::class.java
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    companion object {
        fun newInstance() = FavouriteFragment()
    }
}