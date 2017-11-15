package iammert.com.frekans.ui.favourite
import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentFavouriteBinding
import iammert.com.frekans.ui.BaseFragment
import iammert.com.frekans.ui.search.SearchFragment

/**
 * Created by mertsimsek on 08/11/2017.
 */
class FavouriteFragment : BaseFragment<FavouriteViewModel, FragmentFavouriteBinding>() {

    override fun getViewModel(): Class<FavouriteViewModel> {
        return FavouriteViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_favourite
    }

    companion object {
        fun newInstance() = FavouriteFragment()
    }
}