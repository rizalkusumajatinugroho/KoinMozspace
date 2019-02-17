package com.smu.koinmozspace.external.constant

import android.widget.ImageView
import com.squareup.picasso.Picasso

/**
 * Created by sapuser on 2/17/2019.
 */
fun ImageView.loadFromUrl(url : String?){
    Picasso.get()
            .load(url)
            .fit()
            .centerCrop()
            .into(this)
}