package iammert.com.frekans.util

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import iammert.com.frekans.R
import iammert.com.frekans.player.PlayerDataState
import iammert.com.frekans.util.view.CircleTransform
import iammert.com.player.PlayerState

/**
 * Created by mertsimsek on 15/11/2017.
 */
enum class Shape {
    SQUARE, CIRCLE
}

@BindingAdapter("imageUrl", "placeHolder", "shape", requireAll = false)
fun load(view: ImageView, url: String?, placeHolder: Drawable?, shape: Shape?) {
    if (url == null) return

    val requestCreator = Picasso.with(view.context)
            .load(url)
            .placeholder(placeHolder)

    requestCreator.apply {
        when (shape) {
            Shape.CIRCLE -> transform(CircleTransform())
            Shape.SQUARE -> TODO()
        }
    }
    requestCreator.into(view)
}


@BindingAdapter("playPauseToggle")
fun setPlayPauseToggle(imageView: ImageView, playerState: PlayerState?) {
    when (playerState) {
        PlayerState.PLAYING -> imageView.setImageResource(R.drawable.ic_pause_white_24)
        else -> {
            imageView.setImageResource(R.drawable.ic_play_arrow_white_24)
        }
    }
}

@BindingAdapter("playerStateText")
fun setPlayerStateText(textView: TextView, playerDataState: PlayerDataState?) {
    playerDataState?.playerState.let {
        when (it) {
            PlayerState.LOADING -> textView.text = textView.context.getString(R.string.label_stream_buffering, playerDataState?.streamIndex?.plus(1))
            PlayerState.ERROR -> textView.text = textView.context.getString(R.string.label_stream_error)
            else -> {
                textView.text = playerDataState?.radio?.radioName
            }
        }
    }
}

