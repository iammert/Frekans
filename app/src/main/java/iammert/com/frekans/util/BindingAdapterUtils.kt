package iammert.com.frekans.util

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by mertsimsek on 15/11/2017.
 */
@BindingAdapter(value = "imageUrl")
fun load(view: ImageView, url: String) = Picasso.with(view.context).load(url).into(view)