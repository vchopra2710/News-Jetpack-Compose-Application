package com.proj.news.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.proj.news.R
import com.proj.news.util.DBG_TAG
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Timber.d("$DBG_TAG, MainActivity")
    }
}