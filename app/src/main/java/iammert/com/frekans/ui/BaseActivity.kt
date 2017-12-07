package iammert.com.frekans.ui

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.LayoutRes
import dagger.android.support.DaggerAppCompatActivity
import iammert.com.frekans.util.delegates.SetContentView
import javax.inject.Inject


/**
 * Created by mertsimsek on 06/11/2017.
 */
abstract class BaseActivity<VM : ViewModel, out DB : ViewDataBinding> : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    protected val binding: DB by contentView(getLayoutRes())

    protected lateinit var viewModel: VM

    @LayoutRes
    abstract fun getLayoutRes(): Int

    abstract fun getViewModel(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
    }

    private fun contentView(@LayoutRes layoutRes: Int): SetContentView<DB> {
        return SetContentView(layoutRes)
    }
}