package com.fidisys.android.booksapp.repository.data

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "invoice")
data class Invoice(
    @PrimaryKey
    @ColumnInfo(name = "invoice_number")
    val invoiceNumber: String,

    @ColumnInfo(name = "invoice_date")
    val invoiceDate: String,

    @ColumnInfo(name = "client_name")
    val clientName: String,

    @ColumnInfo(name = "client_address")
    val clientAddress: String,

    @ColumnInfo(name = "client_pin_code")
    val clientPinCode: String,

    @ColumnInfo(name = "product_name")
    val productName: String,

    @ColumnInfo(name = "product_description")
    val productDescription: String,

    @ColumnInfo(name = "billing_hours")
    val billingHours: String,

    @ColumnInfo(name = "billing_price")
    val billingPrice: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(invoiceNumber)
        parcel.writeString(invoiceDate)
        parcel.writeString(clientName)
        parcel.writeString(clientAddress)
        parcel.writeString(clientPinCode)
        parcel.writeString(productName)
        parcel.writeString(productDescription)
        parcel.writeString(billingHours)
        parcel.writeString(billingPrice)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Invoice> {
        override fun createFromParcel(parcel: Parcel): Invoice {
            return Invoice(parcel)
        }

        override fun newArray(size: Int): Array<Invoice?> {
            return arrayOfNulls(size)
        }
    }
}