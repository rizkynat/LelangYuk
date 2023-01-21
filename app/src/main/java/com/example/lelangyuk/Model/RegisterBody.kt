package com.example.lelangyuk.Model

import com.google.gson.annotations.SerializedName

data class RegisterBody(
    @SerializedName("nama_lengkap")
    val nama_lengkap: String,
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String
)
