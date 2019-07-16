package com.fidisys.android.booksapp.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fidisys.android.booksapp.R
import com.fidisys.android.booksapp.repository.data.Invoice
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 *
 */
class InvoicePreviewFragment : Fragment() {

    private var invoice: Invoice? = null

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invoice_preview, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
    }

    private fun setUpViews() {
        invoice = arguments?.getParcelable("invoice")
        Timber.d("args invoice %s", invoice)
    }

}
