package com.fidisys.android.booksapp.view.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.fidisys.android.booksapp.R
import kotlinx.android.synthetic.main.activity_invoice_edit.*

class InvoiceEditActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_invoice_edit)
        setUpViews()
    }

    private fun setUpViews() {
        action_button_create_invoice.setOnClickListener {
            findNavController(R.id.action_button_create_invoice).navigate(R.id.invoiceListsFragment)
        }
    }
}
