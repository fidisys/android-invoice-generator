package com.fidisys.android.booksapp.pdf

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.RectF
import android.graphics.pdf.PdfDocument
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import com.fidisys.android.booksapp.data.Pdf
import java.io.File
import java.io.FileOutputStream

class PdfManager constructor(private val invoiceView: ConstraintLayout, private val pdf: Pdf) : PdfGeneratorCallback {

    override fun generatePdf() {
        val pdfDocument = PdfDocument()
        val page = pdfDocument.startPage(pageInfo(pdf.pageWidth, pdf.pageHeight, pdf.pageNumber))
        designPage(invoiceView)
    }

    private fun pageInfo(pageWidth: Int, pageHeight: Int, pageNumber: Int): PdfDocument.PageInfo {
        return PdfDocument.PageInfo.Builder(pageWidth, pageHeight, pageNumber).create()
    }

    private fun designPage(view: ConstraintLayout) {
        val bitmap: Bitmap = getBitmap(view)
        val document = PdfDocument()
        val pageInfo: PdfDocument.PageInfo = PdfDocument.PageInfo
            .Builder(pdf.pageWidth, pdf.pageHeight, 1)
            .create()
//        val content: RectF = RectF(pageInfo.contentRect)
//        Log.d("cwidth", content.width().toString())
//        Log.d("cheight", content.height().toString())
//        val contentPostScriptWidth = (content.width() * 1.33333).toInt()
//        val contentPostScriptHeight = (content.height() * 1.33333).toInt()
//        Log.d("cwidthpx", contentPostScriptWidth.toString())
//        Log.d("cheightpx", contentPostScriptHeight.toString())
//        Log.d("bwidthpx", bitmap.width.toString())
//        Log.d("bheightpx", bitmap.height.toString())
        //val scaledBitmap = Bitmap.createScaledBitmap(bitmap,contentPostScriptWidth-20,contentPostScriptHeight-20,false)
        //var scale = contentPostScriptWidth/bitmap.pageWidth
        // scale = Math.max(scale,contentPostScriptHeight/bitmap.pageHeight)
        // val matrix= Matrix()
        // matrix.postScale(scale.toFloat(), scale.toFloat())
        //val translateX = (contentPostScriptWidth - bitmap.getPageWidth() * scale) / 2;
        //val translateY = (contentPostScriptHeight- bitmap.getPageHeight() * scale) / 2;
        //matrix.postTranslate(translateX.toFloat(), translateY.toFloat());
        //scaledBitmap.density = DisplayMetrics.DENSITY_XHIGH
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, pdf.displayWidth, pdf.displayHeight, false)
        val page: PdfDocument.Page = document.startPage(pageInfo)
        val canvas: Canvas = page.canvas
        canvas.scale(0.5f,0.5f)
        //canvas.density = DisplayMetrics.DENSITY_HIGH
        canvas.drawBitmap(scaledBitmap, 0f,0f, null)
        document.finishPage(page)
        writeContentToFile(pdf.file, document)
    }

//    private fun designPage(view: ConstraintLayout) {
//        val bitmap: Bitmap = getBitmap(view)
//        val document = PdfDocument()
//        val pageInfo: PdfDocument.PageInfo = PdfDocument.PageInfo.Builder(595, 842, 1).create()
//        val content: RectF = RectF(pageInfo.contentRect)
//        Log.d("cwidth", content.pageWidth().toString())
//        Log.d("cheight", content.pageHeight().toString())
//        val contentPostScriptWidth = (content.pageWidth() * 1.33333).toInt()
//        val contentPostScriptHeight = (content.pageHeight() * 1.33333).toInt()
//        Log.d("cwidthpx", contentPostScriptWidth.toString())
//        Log.d("cheightpx", contentPostScriptHeight.toString())
//        Log.d("bwidthpx", bitmap.pageWidth.toString())
//        Log.d("bheightpx", bitmap.pageHeight.toString())
//        //val scaledBitmap = Bitmap.createScaledBitmap(bitmap,contentPostScriptWidth-20,contentPostScriptHeight-20,false)
//        //var scale = contentPostScriptWidth/bitmap.pageWidth
//       // scale = Math.max(scale,contentPostScriptHeight/bitmap.pageHeight)
//       // val matrix= Matrix()
//       // matrix.postScale(scale.toFloat(), scale.toFloat())
//        //val translateX = (contentPostScriptWidth - bitmap.getPageWidth() * scale) / 2;
//        //val translateY = (contentPostScriptHeight- bitmap.getPageHeight() * scale) / 2;
//        //matrix.postTranslate(translateX.toFloat(), translateY.toFloat());
//        //scaledBitmap.density = DisplayMetrics.DENSITY_XHIGH
//        val page: PdfDocument.Page = document.startPage(pageInfo)
//        val canvas: Canvas = page.canvas
//        canvas.density = DisplayMetrics.DENSITY_HIGH
//        canvas.drawBitmap(bitmap, 20f,20f, null)
//        document.finishPage(page)
//        writeContentToFile(pdf.file, document)
//    }

    private fun getPageCanvas(page: PdfDocument.Page): Canvas {
        val canvas = page.canvas
        //canvas.scale(0.5f, 0.5f)
        return canvas
    }

    private fun getBitmap(view: ConstraintLayout): Bitmap {
//        val bitmap = Bitmap.createBitmap(595, 842, Bitmap.Config.ARGB_8888)
//        val canvas = Canvas(bitmap)
//        val drawable = view.background
//        drawable.draw(canvas)
//        view.draw(canvas)
//        return bitmap

//        if (pageWidth > 0 && pageHeight > 0) {
//        view.measure(View.MeasureSpec.makeMeasureSpec(200.topx(), View.MeasureSpec.EXACTLY),
//                View.MeasureSpec.makeMeasureSpec(200.topx(), View.MeasureSpec.EXACTLY))
//        }
//        view.measure(View.MeasureSpec.UNSPECIFIED,View.MeasureSpec.UNSPECIFIED)
//        view.layout(0, 0, view.measuredWidth, view.measuredHeight)

        val bitmap = Bitmap.createBitmap(pdf.viewWidth,
                pdf.viewHeight, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        val background = view.background

        background?.draw(canvas)
        view.draw(canvas)

        return bitmap
    }

    fun Int.topx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()

    private fun writeContentToFile(file: File, pdfDocument: PdfDocument) {
        val fos = FileOutputStream(file)
        pdfDocument.writeTo(fos)
        pdfDocument.close()
    }


}