package com.latihan.cnn.data.article

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
// TODO: ini masih salah lohh 
data class ArticleEntity(
    @PrimaryKey
    @Expose
    @SerializedName("id_room")
    val idRoom: Int?,
    @Expose
    @SerializedName("id")
    val id: Int?,
    @Expose
    @SerializedName("name")
    val name: String?,
    @Expose
    @SerializedName("bio")
    val bio: String?
): Parcelable