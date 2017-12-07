package iammert.com.frekans.ui.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import iammert.com.frekans.R
import iammert.com.frekans.databinding.FragmentSettingsBinding
import iammert.com.frekans.ui.BaseFragment
import iammert.com.frekans.util.delegates.inflate

/**
 * Created by mertsimsek on 08/11/2017.
 */
class SettingsFragment : BaseFragment<SettingsViewModel>() {

    private val binding: FragmentSettingsBinding by inflate(R.layout.fragment_settings)

    override fun getViewModel(): Class<SettingsViewModel> {
        return SettingsViewModel::class.java
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return binding.root
    }

    companion object {
        fun newInstance() = SettingsFragment()
    }
}