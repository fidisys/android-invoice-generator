package com.fidisys.android.invoiceapp.repository.data

import java.io.File

data class Pdf(
    val viewWidth: Int,
    val viewHeight: Int,
    val pageWidth: Int,
    val pageHeight: Int,
    val pageNumber: Int,
    val displayWidth: Int,
    val displayHeight: Int,
    val file: File
) {}
