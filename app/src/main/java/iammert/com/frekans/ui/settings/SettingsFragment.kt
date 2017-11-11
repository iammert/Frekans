package iammert.com.frekans.ui.settings

import dagger.android.DaggerFragment
import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentSettingsBinding
import iammert.com.frekans.ui.BaseFragment

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

}