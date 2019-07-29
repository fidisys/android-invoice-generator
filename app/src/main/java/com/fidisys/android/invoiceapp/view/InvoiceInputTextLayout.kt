package com.fidisys.android.invoiceapp.view

import android.content.Context
import android.util.AttributeSet
import com.google.android.material.textfield.TextInputLayout

class InvoiceInputTextLayout : TextInputLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )
}
