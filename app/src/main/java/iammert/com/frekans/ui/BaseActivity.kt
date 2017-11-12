package iammert.com.frekans.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import javax.inject.Inject


/**
 * Created by mertsimsek on 06/11/2017.
 */
abstract class BaseActivity<VM : ViewModel, DB : ViewDataBinding> : AppCompatActivity() {

    @Inject
    private lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var binding: DB

    protected lateinit var viewModel: VM

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun getViewModel(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = DataBindingUtil.setContentView(this, getLayoutRes())
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
    }
}