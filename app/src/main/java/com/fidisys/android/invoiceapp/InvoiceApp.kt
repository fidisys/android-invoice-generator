package com.fidisys.android.invoiceapp

import android.app.Application
import android.content.Context
import com.fidisys.android.invoiceapp.log.TimberThreadDebugTree
import timber.log.Timber

class InvoiceApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Timber.plant(TimberThreadDebugTree())
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
    }
}