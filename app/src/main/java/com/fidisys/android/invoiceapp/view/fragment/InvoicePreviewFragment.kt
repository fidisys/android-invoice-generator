package com.fidisys.android.invoiceapp.view.fragment


import android.os.Environment
import android.util.DisplayMetrics
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.Fragment
import com.fidisys.android.invoiceapp.R
import com.fidisys.android.invoiceapp.base.BaseFragment
import com.fidisys.android.invoiceapp.pdf.PdfManager
import com.fidisys.android.invoiceapp.repository.data.Invoice
import com.fidisys.android.invoiceapp.repository.data.Pdf
import timber.log.Timber
import java.io.File

/**
 * A simple [Fragment] subclass.
 *
 */
class InvoicePreviewFragment : BaseFragment() {

    private var invoice: Invoice? = null
    private lateinit var viewGroup: ConstraintLayout

    override fun setUpView(view: View) {
        viewGroup = view.findViewById(R.id.invoice_preview)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_invoice_preview
    }

    private fun generatePdf() {
        //invoice = arguments?.getParcelable("invoice")
        //Timber.d("args %s", invoice?.name)
        val displayMetrics = DisplayMetrics()
        activity?.windowManager?.defaultDisplay?.getMetrics(displayMetrics)
        val displayWidth = displayMetrics.widthPixels
        val displayHeight = displayMetrics.heightPixels
        Timber.d("view width %s", viewGroup.width)
        Timber.d("view height %s", viewGroup.height)
        val pdf = Pdf(
            viewGroup.width,
            viewGroup.height,
            595,
            842,
            1,
            displayWidth,
            displayHeight,
            createFileInStorage()
        )
        val pdfManager = PdfManager(viewGroup, pdf)
        pdfManager.generatePdf()
    }


    /**
     * Return the file which created on external or internal memory.
     *
     * @return newly created file.
     */
    private fun createFileInStorage(): File {
        // Create a media file name
        val pdfFile: File
        val timeStamp = System.currentTimeMillis()
        val mImageName = "FM_$timeStamp.pdf"

        //        Log.d("path name ", getThisAppStorageDirectory().getPath());
        //        mediaFile = new File(getThisAppStorageDirectory() + File.separator + mImageName);

        //        Log.d("path name ", getThisAppStorageDirectoryWithNewFolder().getPath());
        //        mediaFile = new File(getThisAppStorageDirectoryWithNewFolder() + File.separator + mImageName);

        //Timber.d("path name ", getPublicAlbumStorageDir().path)
        pdfFile = File(getPublicAlbumStorageDir(), mImageName)

        //        Log.d("path name ",getPrivateAlbumStorageDir().getPath());
        //        mediaFile = new File(getPrivateAlbumStorageDir() , mImageName);

        //        if (isExternalStorageWritable() && isExternalStorageReadable()) {
        //            Log.d("read|write", "true");
        //            Log.d("path name ", getPublicAlbumStorageDir().getPath());
        //            mediaFile = new File(getPublicAlbumStorageDir(), mImageName);
        //        }

        return pdfFile
    }

    private fun getPublicAlbumStorageDir(): File {
        val file =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES)
        if (!file.exists())
            file.mkdirs()

        return file
    }
}