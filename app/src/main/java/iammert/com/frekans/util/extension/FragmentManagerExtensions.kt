package iammert.com.frekans.util.extension

import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction


/**
 * Created by mertsimsek on 30/11/2017.
 */
fun FragmentManager.transaction(func: FragmentTransaction.() -> FragmentTransaction) {
    beginTransaction().func().commit()
}

fun FragmentManager.trans(func: FragmentTransaction.() -> FragmentTransaction) {
    val bt = beginTransaction().func().commit()
}