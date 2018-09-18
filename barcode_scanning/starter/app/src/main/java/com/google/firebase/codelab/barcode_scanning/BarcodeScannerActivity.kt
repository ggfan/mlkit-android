package com.google.firebase.codelab.barcode_scanning

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.otaliastudios.cameraview.CameraListener
import kotlinx.android.synthetic.main.activity_main.*

class BarcodeScannerActivity : BaseCameraActivity() {

    private val qrList = arrayListOf<QrCode>()
    val adapter = QrCodeAdapter(qrList)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        rvQrCode.layoutManager = LinearLayoutManager(this)
        rvQrCode.adapter = adapter

        cameraView.addCameraListener(object : CameraListener() {
            override fun onPictureTaken(jpeg: ByteArray?) {
                val bitmap = jpeg?.size?.let { BitmapFactory.decodeByteArray(jpeg, 0, it) }
                bitmap?.let { runBarcodeScanner(it) }
                showPreview()
                imagePreview.setImageBitmap(bitmap)
            }

        })
    }

    private fun runBarcodeScanner(bitmap: Bitmap) {
        //Create a FirebaseVisionImage

        //Optional : Define what kind of barcodes you want to scan

        //Get access to an instance of FirebaseBarcodeDetector

    }

    override fun onClick(v: View?) {
        progressBar.visibility = View.VISIBLE
        cameraView.captureSnapshot()
    }
}