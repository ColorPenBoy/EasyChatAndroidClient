package com.king.easychat.binding

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.king.base.util.TimeUtils
import com.king.easychat.R

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */


@BindingAdapter(value = ["time"])
fun TextView.dateFormat(time: String?){
    time?.run {
        text = TimeUtils.formatDate(time,TimeUtils.FORMAT_Y_TO_M_EN)
    } ?: run {
        text = ""
    }

}

@BindingAdapter(value = ["imageUrl","imageDefault"])
fun ImageView.imageUrl(imageUrl: String?,imageDefault: Int){
    imageUrl?.run {

    } ?: run {
        setImageResource(imageDefault)
    }

}