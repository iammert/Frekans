package iammert.com.frekans

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import iammert.com.frekans.di.component.DaggerAppComponent
import iammert.com.frekans.util.tool.Tools
import javax.inject.Inject

/**
 * Created by mertsimsek on 08/11/2017.
 */
class FrekansApplication : DaggerApplication() {

    @Inject lateinit var tools: Tools

    override fun onCreate() {
        super.onCreate()
        tools.init(this)
    }

    override fun applicationInjector(): AndroidInjector<out FrekansApplication> =
            DaggerAppComponent.builder().create(this)

}