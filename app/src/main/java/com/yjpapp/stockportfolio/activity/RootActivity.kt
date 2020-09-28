package com.yjpapp.stockportfolio.activity

import android.content.Context
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yjpapp.stockportfolio.BuildConfig
import com.yjpapp.stockportfolio.R
import java.util.logging.Logger

open class RootActivity(contentLayout: Int) : AppCompatActivity(contentLayout) {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(R.layout.activity_root)
    }

    fun logcat(msg: String){
        if(BuildConfig.LOG_CAT) Log.d(javaClass.simpleName, msg)
    }
}