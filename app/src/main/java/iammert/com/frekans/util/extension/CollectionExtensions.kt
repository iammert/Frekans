package iammert.com.frekans.util.extension

/**
 * Created by mertsimsek on 14/12/2017.
 */
fun <T> ArrayList<T>.addIfAbsent(data: T) {
    if (!this.contains(data)) {
        this.add(data)
    }
}

fun <T> ArrayList<T>.removeIfExist(data: T) {
    if (this.contains(data)) {
        this.remove(data)
    }
}