package iammert.com.frekans

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import iammert.com.frekans.di.DaggerAppComponent

/**
 * Created by mertsimsek on 08/11/2017.
 */
class FrekansApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}