package com.fidisys.android.booksapp.log;


import timber.log.Timber;

/**
 * Timber base logtree.
 */
public class TimberThreadDebugTree extends Timber.DebugTree {
    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        String currentThread = Thread.currentThread().getName();
        if (currentThread.trim().isEmpty()) {
            super.log(priority, tag, message, t);
        } else {
            super.log(priority, tag, new StringBuffer(currentThread).append("\n").append(message).toString(), t);
        }
    }
}
