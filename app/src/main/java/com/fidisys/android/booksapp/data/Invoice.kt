package com.fidisys.android.booksapp.data

import android.os.Parcel
import android.os.Parcelable

data class Invoice(
    val invoiceNumber: String,
    val invoiceDate: String,
    val clientName: String,
    val clientAddress: String,
    val clientPinCode: String,
    val productName: String,
    val productDescription: String,
    val billingHours: String,
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