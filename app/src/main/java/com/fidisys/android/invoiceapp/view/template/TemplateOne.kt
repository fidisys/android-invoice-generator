package com.fidisys.android.invoiceapp.view.template

import android.content.Context
import android.util.AttributeSet
import androidx.annotation.AttrRes
import androidx.constraintlayout.widget.ConstraintLayout

class TemplateOne : ConstraintLayout {
    constructor(context: Context) : super(context)
    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, @AttrRes defStyleAttr: Int) : super(
        context,
        attributeSet,
        defStyleAttr
    )
}