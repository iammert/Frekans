package iammert.com.frekans.data.remote

import iammert.com.frekans.data.remote.model.Genre
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by mertsimsek on 12/11/2017.
 */
interface FrekansService {

    @GET("genre")
    fun getGenres(): Single<List<Genre>>
}