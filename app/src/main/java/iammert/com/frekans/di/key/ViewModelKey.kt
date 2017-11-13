package iammert.com.frekans.di.key

import android.arch.lifecycle.ViewModel
import dagger.MapKey
import iammert.com.frekans.ui.favourite.FavouriteViewModel
import kotlin.reflect.KClass

/**
 * Created by mertsimsek on 12/11/2017.
 */
@MapKey
@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.FUNCTION,  AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)