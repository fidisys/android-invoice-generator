package com.fidisys.android.booksapp.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.fidisys.android.booksapp.repository.InvoiceRepository
import com.fidisys.android.booksapp.repository.db.InvoiceDatabase

class InvoiceViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: InvoiceRepository

    init {
        val invoiceDao = InvoiceDatabase.getDatabase(application).invoiceDao()
        repository = InvoiceRepository(invoiceDao)
    }
}