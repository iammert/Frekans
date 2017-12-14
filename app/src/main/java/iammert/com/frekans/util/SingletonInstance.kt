package iammert.com.frekans.util

/**
 * Created by mertsimsek on 14/12/2017.
 */
open class SingletonInstance<in P, out R>(data: (P) -> R) {
    private var creator: ((P) -> R)? = data
    private var INSTANCE: R? = null

    fun getInstance(param: P): R? {
        val i = INSTANCE
        if (i != null) {
            return i
        }

        return synchronized(this) {
            val i2 = INSTANCE
            if (i2 != null) {
                i2
            } else {
                val created = creator!!(param)
                INSTANCE = created
                creator = null
                created
            }
        }
    }

}