package com.google.firebase.codelab.barcode_scanning

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*

class QrCodeAdapter(private val qrList: ArrayList<QrCode>) : RecyclerView.Adapter<QrCodeAdapter.QrHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QrHolder {
        return QrHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false))
    }

    override fun getItemCount() = qrList.size

    override fun onBindViewHolder(holder: QrHolder, position: Int) {
        with(qrList[position]) {
            holder.itemView.qrType.text = this.type
            holder.itemView.qrValue.text = this.value
        }
    }

    class QrHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}