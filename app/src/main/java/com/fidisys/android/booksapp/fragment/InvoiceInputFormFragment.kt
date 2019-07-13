package com.fidisys.android.booksapp.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.fidisys.android.booksapp.R
import com.fidisys.android.booksapp.data.Invoice
import kotlinx.android.synthetic.main.fragment_invoice_input_form.*
import timber.log.Timber

/**
 * A simple [Fragment] subclass.
 *
 */
class InvoiceInputFormFragment : Fragment() {

    lateinit var invoice: Invoice

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invoice_input_form, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    private fun setUpViews(view: View) {
        invoice_save_button.setOnClickListener { navigateToPreview(view) }
    }

    private fun navigateToPreview(v: View) {
        if (validateInputForms()) {
            invoice = Invoice("Fidisys")
            val bundle = bundleOf("invoice" to invoice)
            Navigation.findNavController(v).navigate(R.id.invoicePreviewFragment, bundle)
        }
    }

    private fun validateInputForms(): Boolean {
        Timber.d("validate")
        return true
    }
}
