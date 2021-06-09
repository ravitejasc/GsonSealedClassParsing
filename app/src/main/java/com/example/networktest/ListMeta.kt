package com.example.networktest


import com.google.gson.annotations.SerializedName

data class ListMeta(
    @SerializedName("orientation")
    val orientation: Int,
    @SerializedName("paddingBetween")
    val paddingBetween: Double,
    @SerializedName("paddingFirst")
    val paddingFirst: Double,
    @SerializedName("paddingLast")
    val paddingLast: Double
)