package com.example.lelangyuk.Model

import com.google.gson.annotations.SerializedName

data class LoginBody(
    @SerializedName("email")
    var email: String,
    @SerializedName("password")
    var password: String
)
