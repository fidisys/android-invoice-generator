package com.fidisys.android.booksapp.view.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.fidisys.android.booksapp.R
import com.fidisys.android.booksapp.repository.data.Invoice
import kotlinx.android.synthetic.main.fragment_invoice_input_form.*

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
        if (!validateInputForms()) {
            invoice = Invoice(
                invoice_number_text.text.toString(),
                invoice_date_text.text.toString(),
                client_name_text.text.toString(),
                client_address_text.text.toString(),
                client_pin_code_text.text.toString(),
                product_name_text.text.toString(),
                product_description_text.text.toString(),
                billing_hours_text.text.toString(),
                billing_price_text.text.toString()
            )
            val bundle = bundleOf("invoice" to invoice)
            Navigation.findNavController(v).navigate(R.id.invoicePreviewFragment, bundle)
        } else {
            Toast.makeText(activity, "Check the mandatory fields", LENGTH_LONG).show()
        }
    }

    private fun validateInputForms(): Boolean {
        var hasErrorOccurred = false

        if (!invoice_number_text.text.isNullOrEmpty() && !invoice_date_text.text.isNullOrEmpty()
            && !product_name_text.text.isNullOrEmpty() && !product_description_text.text.isNullOrEmpty()
            && !billing_hours_text.text.isNullOrEmpty() && !billing_price_text.text.isNullOrEmpty()
            && !client_name_text.text.isNullOrEmpty() && !client_address_text.text.isNullOrEmpty()
            && !client_pin_code_text.text.isNullOrEmpty()
        ) {
            return hasErrorOccurred
        } else {

            if (invoice_number_text.text.toString().isEmpty()) {
                invoice_number_input.error =
                    "Error: invoice number required"
                hasErrorOccurred = true
            }

            if (invoice_date_text.text.toString().isEmpty()) {
                invoice_date_input.error =
                    "Error: invoice date is required"
                hasErrorOccurred = true
            }

            if (product_name_text.text.toString().isEmpty()) {
                product_name_input.error =
                    "Error: product name cannot be empty"
                hasErrorOccurred = true
            }

            if (product_description_text.text.toString().isEmpty()) {
                product_description_input.error =
                    "Error: product description is empty"
                hasErrorOccurred = true
            }

            if (billing_hours_text.text.toString().isEmpty()) {
                billing_hours_input.error =
                    "Error: no of hours must be given"
                hasErrorOccurred = true
            }

            if (billing_price_text.text.toString().isEmpty()) {
                billing_price_input.error =
                    "Error: mention the price per hour"
                hasErrorOccurred = true
            }

            if (client_name_text.text.toString().isEmpty()) {
                client_name_input.error =
                    "Error: name should not be blank"
                hasErrorOccurred = true
            }

            if (client_address_text.text.toString().isEmpty()) {
                client_address_input.error =
                    "Error: client address cannot be empty"
                hasErrorOccurred = true
            }

            if (client_pin_code_text.text.toString().isEmpty()) {
                client_pin_code_input.error =
                    "Error: client pin code cannot be empty"
                hasErrorOccurred = true
            }
            return hasErrorOccurred
        }
    }
}
