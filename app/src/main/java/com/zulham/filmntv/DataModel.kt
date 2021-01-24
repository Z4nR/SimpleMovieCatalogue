package com.zulham.filmntv

import android.os.Parcel
import android.os.Parcelable

data class DataModel(
    val title: String?,
    val releaseDate: String?,
    val genre: String?,
    val production: String?,
    val desc: String?,
    val img: Int
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)
        parcel.writeString(releaseDate)
        parcel.writeString(genre)
        parcel.writeString(production)
        parcel.writeString(desc)
        parcel.writeInt(img)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<DataModel> {
        override fun createFromParcel(parcel: Parcel): DataModel {
            return DataModel(parcel)
        }

        override fun newArray(size: Int): Array<DataModel?> {
            return arrayOfNulls(size)
        }
    }
}