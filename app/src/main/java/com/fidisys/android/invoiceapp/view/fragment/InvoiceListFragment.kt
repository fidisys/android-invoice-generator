package com.fidisys.android.invoiceapp.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.fidisys.android.invoiceapp.R
import kotlinx.android.synthetic.main.fragment_invoice_list.*

class InvoiceListFragment : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews(view)
    }

    private fun setUpViews(view: View) {
        action_button_create_invoice.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.invoiceInputFieldsFragment)
        }
    }
}