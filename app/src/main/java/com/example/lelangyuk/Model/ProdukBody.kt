package com.example.lelangyuk.Model

import com.google.gson.annotations.SerializedName

data class ProdukBody (
    @SerializedName("nama_produk")
    val nama_produk: String,
    @SerializedName("deskripsi")
    var deskripsi   : String,
    @SerializedName("harga_dasar")
    var harga_dasar: String,
    @SerializedName("harga_capaian")
    val harga_capaian: String,
    @SerializedName("kategori")
    var kategori   : String,
    @SerializedName("status_aktif")
    var status_aktif: String,
    @SerializedName("stasus_suka")
    val status_suka: String,
    @SerializedName("img_url")
    var img_url   : String,
    @SerializedName("jadwal_open")
    var jadwal_open: String,
)