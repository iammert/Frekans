package iammert.com.frekans.ui.settings

import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentSettingsBinding
import iammert.com.frekans.ui.BaseFragment
import iammert.com.frekans.ui.search.SearchFragment

/**
 * Created by mertsimsek on 08/11/2017.
 */
class SettingsFragment : BaseFragment<SettingsViewModel, FragmentSettingsBinding>() {

    override fun getViewModel(): Class<SettingsViewModel> {
        return SettingsViewModel::class.java
    }

    override fun getLayoutRes(): Int {
        return R.layout.fragment_settings
    }

    companion object {
        fun newInstance() = SettingsFragment()
    }
}