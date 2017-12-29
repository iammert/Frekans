package iammert.com.data.util

import iammert.com.data.local.entity.RadioEntity
import iammert.com.data.remote.model.Radio

/**
 * Created by mertsimsek on 29/12/2017.
 */
fun RadioEntity.toRadio(radioEntity: RadioEntity): Radio {
    return Radio(id, radioName, website, band, city, dial, language, country, streams, logoSmall, logoBig, listenerCount)
}

fun Radio.toRadioEntity(): RadioEntity {
    return RadioEntity(id, radioName, website, band, city, dial, language, country, streams, logoSmall, logoBig, listenerCount)
}