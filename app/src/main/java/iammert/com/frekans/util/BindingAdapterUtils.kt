package iammert.com.frekans.util

import android.databinding.BindingAdapter
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by mertsimsek on 15/11/2017.
 */
@BindingAdapter("imageUrl", "placeHolder")
fun load(view: ImageView, url: String, placeHolder: Drawable) = Picasso.with(view.context)
        .load(url)
        .placeholder(placeHolder)
        .into(view)

