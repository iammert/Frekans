package iammert.com.frekans.util.tool

import android.app.Application
import com.facebook.stetho.Stetho
import iammert.com.frekans.util.extension.debug
import javax.inject.Inject

/**
 * Created by mertsimsek on 20/11/2017.
 */
class Tools(private val tools: List<Tool>) : Tool {

    override fun init(app: Application) {
        for (tool in tools) {
            tool.init(app)
        }
    }
}

class StethoTool @Inject constructor() : Tool {
    override fun init(app: Application) {
        debug { Stetho.initializeWithDefaults(app) }
    }
}