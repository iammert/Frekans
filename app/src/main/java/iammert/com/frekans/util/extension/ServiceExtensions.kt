package iammert.com.frekans.util.extension

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.IBinder

/**
 * Created by mertsimsek on 19/12/2017.
 */
open class ServiceConnectionAdapter : ServiceConnection {

    private lateinit var onServiceConnected: (ComponentName?, IBinder?) -> Unit
    private lateinit var onServiceDisconnected: (ComponentName?) -> Unit

    override fun onServiceConnected(p0: ComponentName?, p1: IBinder?) {
        onServiceConnected.invoke(p0, p1)
    }

    fun serviceConnected(func: (ComponentName?, IBinder?) -> Unit) {
        onServiceConnected = func
    }

    override fun onServiceDisconnected(p0: ComponentName?) {
        onServiceDisconnected.invoke(p0)
    }

    fun onServiceDisconnected(func: (ComponentName?) -> Unit) {
        onServiceDisconnected = func
    }
}

fun connection(connection: ServiceConnectionAdapter.() -> Unit): ServiceConnection {
    val connectionAdapter = ServiceConnectionAdapter()
    connectionAdapter.connection()
    return connectionAdapter
}


