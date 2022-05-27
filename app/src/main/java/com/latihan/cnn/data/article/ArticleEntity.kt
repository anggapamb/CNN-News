package com.latihan.cnn.data.article

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class ArticleEntity(
    @PrimaryKey
    @Expose
    @SerializedName("id_room")
    val idRoom: Int?,
    @Expose
    @SerializedName("id")
    val id: Int?,
    @Expose
    @SerializedName("link")
    val link: String?,
    @Expose
    @SerializedName("title")
    val title: String?,
    @Expose
    @SerializedName("pubDate")
    val pubDate: String?,
    @Expose
    @SerializedName("description")
    val description: String?,
    @Expose
    @SerializedName("thumbnail")
    val thumbnail: String?
): Parcelable