package com.fidisys.android.invoiceapp.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.fidisys.android.invoiceapp.repository.InvoiceRepository
import com.fidisys.android.invoiceapp.repository.db.InvoiceDatabase

class InvoiceViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: InvoiceRepository

    init {
        val invoiceDao = InvoiceDatabase.getDatabase(application).invoiceDao()
        repository = InvoiceRepository(invoiceDao)
    }
}