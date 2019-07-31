package com.fidisys.android.invoiceapp.view.fragment

import android.view.View
import androidx.navigation.Navigation
import com.fidisys.android.invoiceapp.R
import com.fidisys.android.invoiceapp.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_invoice_list.*

class InvoiceListFragment : BaseFragment() {

    override fun getLayout(): Int {
        return R.layout.fragment_invoice_list
    }

    override fun setUpView(view: View) {
        action_button_create_invoice.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.invoiceInputFieldsFragment)
        }
    }
}