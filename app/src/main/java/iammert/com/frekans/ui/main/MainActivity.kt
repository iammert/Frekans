package iammert.com.frekans.ui.main

import android.os.Bundle
import iammert.com.frekans.R
import iammert.com.frekans.databinding.ActivityMainBinding
import iammert.com.frekans.ui.BaseActivity

/**
 * Created by mertsimsek on 06/11/2017.
 */
class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    override fun getLayoutRes(): Int {
        return R.layout.activity_main
    }

    override fun getViewModel(): Class<MainViewModel> {
        return MainViewModel::class.java
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

}