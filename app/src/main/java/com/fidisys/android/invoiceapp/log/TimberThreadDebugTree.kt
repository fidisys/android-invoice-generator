package com.fidisys.android.invoiceapp.log


import timber.log.Timber

/**
 * Timber base logtree.
 */
class TimberThreadDebugTree : Timber.DebugTree() {
    override fun log(priority: Int, tag: String, message: String, t: Throwable?) {
        val currentThread = Thread.currentThread().name
        if (currentThread.trim { it <= ' ' }.isEmpty()) {
            super.log(priority, tag, message, t)
        } else {
            super.log(priority, tag, StringBuffer(currentThread).append("\n").append(message).toString(), t)
        }
    }
}
