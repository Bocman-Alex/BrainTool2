package com.example.braintool

import android.os.Parcel
import android.os.Parcelable
import java.io.Serializable

data class Group( val title : String): Parcelable {
    constructor(parcel: Parcel) : this(parcel.readString()?:"") {
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(title)

    }

    companion object CREATOR : Parcelable.Creator<Group> {
        override fun createFromParcel(parcel: Parcel): Group {
            return Group(parcel)
        }

        override fun newArray(size: Int): Array<Group?> {
            return arrayOfNulls(size)
        }
    }
}
