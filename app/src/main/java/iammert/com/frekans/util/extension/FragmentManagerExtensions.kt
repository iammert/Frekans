package iammert.com.frekans.util.extension

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction


/**
 * Created by mertsimsek on 30/11/2017.
 */
inline fun FragmentManager.transaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}