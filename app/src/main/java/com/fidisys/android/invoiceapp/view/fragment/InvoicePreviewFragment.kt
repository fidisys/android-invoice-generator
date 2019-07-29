package com.fidisys.android.invoiceapp.view.fragment


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.fidisys.android.invoiceapp.repository.data.Invoice
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 *
 */
class InvoicePreviewFragment : Fragment() {

    private var invoice: Invoice? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        invoice = arguments?.getParcelable("invoice")
        Timber.d("args invoice %s", invoice)
    }
}
