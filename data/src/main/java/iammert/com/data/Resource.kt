package iammert.com.data

/**
 * Created by mertsimsek on 20/11/2017.
 */
class Resource<T> private constructor(val status: Status, val data: T?) {
    companion object {
        fun <T> error() = Resource(Status.ERROR, null)
        fun <T> success(data: T) = Resource(Status.SUCCESS, data)
        fun <T> loading(data: T) = Resource(Status.LOADING, data)
    }
}