package com.example.networktest


import com.google.gson.annotations.SerializedName

data class ActionData(
    @SerializedName("requestType")
    val requestType: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("url")
    val url: String
)