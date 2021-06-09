package com.example.networktest

import com.google.gson.annotations.SerializedName

data class FeedResponse(
    @SerializedName("a")
    val a: String,
    @SerializedName("bg")
    val bg: String,
    @SerializedName("bgHex")
    val bgHex: Boolean,
    @SerializedName("elements")
    val elements: List<DesignComponent>,
    @SerializedName("t")
    val t: String
)