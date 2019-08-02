package com.fidisys.android.invoiceapp.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.fidisys.android.invoiceapp.R
import com.google.android.material.card.MaterialCardView

class InvoiceDashBoardItemView(context: Context, attrs: AttributeSet) : MaterialCardView(context, attrs) {

    init {
        View.inflate(context, R.layout.layout_item_dashboard, this)
        val imageView: ImageView = findViewById(R.id.image_item_icon)
        val textView: TextView = findViewById(R.id.text_item_title)
        val attributes = context.obtainStyledAttributes(attrs, R.styleable.InvoiceDashBoardItemView)
        imageView.setImageDrawable(attributes.getDrawable(R.styleable.InvoiceDashBoardItemView_image))
        textView.text = attributes.getString(R.styleable.InvoiceDashBoardItemView_text)
        attributes.recycle()
    }
}