package iammert.com.data.util

import iammert.com.data.local.entity.RadioEntity
import iammert.com.data.local.entity.TrendingEntity
import iammert.com.data.remote.model.Radio
import iammert.com.frekans.data.local.entity.GenreEntity
import iammert.com.frekans.data.remote.model.Genre

/**
 * Created by mertsimsek on 29/12/2017.
 */

fun RadioEntity.toTrending(): TrendingEntity{
    return TrendingEntity(radioId = id)
}

fun Radio.toRadioEntity(): RadioEntity {
    return RadioEntity(id, radioName, website, band, city, dial, language, country, streams, logoSmall, logoBig, listenerCount)
}

fun Genre.toGenreEntity(): GenreEntity {
    return GenreEntity(genreId, genreName, imageUrl)
}