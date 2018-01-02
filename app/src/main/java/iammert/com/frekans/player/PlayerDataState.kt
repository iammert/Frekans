package iammert.com.frekans.player

import iammert.com.data.local.entity.RadioEntity
import iammert.com.player.PlayerState

/**
 * Created by mertsimsek on 02/01/18.
 */
data class PlayerDataState(val radio: RadioEntity, val playerState: PlayerState, val streamIndex: Int)