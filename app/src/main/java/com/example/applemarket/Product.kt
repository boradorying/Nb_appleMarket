package com.example.applemarket

import android.os.Parcel
import android.os.Parcelable


data class Product(

    val imageResourceId: Int,
    val productName: String,
    val productDescription: String,
    val seller: String,
    val price: String,
    val address: String,
    val review: Int,
    var like: Int,
    var position: Int,
    var isLiked: Boolean
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readBoolean()
    )


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(imageResourceId)
        parcel.writeString(productName)
        parcel.writeString(productDescription)
        parcel.writeString(seller)
        parcel.writeString(price)
        parcel.writeString(address)
        parcel.writeInt(review)
        parcel.writeInt(like)
        parcel.writeInt(position)
        parcel.writeBoolean(isLiked)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }

}
