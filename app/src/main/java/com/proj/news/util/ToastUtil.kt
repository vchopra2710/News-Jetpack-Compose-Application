package com.proj.news.util

import android.content.Context
import android.widget.Toast

fun toastIt(ctx: Context?, msg: String?) {
    ctx?.let {
        Toast.makeText(it, msg, Toast.LENGTH_LONG).show()
    }

}