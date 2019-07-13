package com.fidisys.android.booksapp

import android.app.Application
import android.content.Context
import com.fidisys.android.booksapp.log.TimberThreadDebugTree
import timber.log.Timber

class BooksApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(TimberThreadDebugTree())
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
}