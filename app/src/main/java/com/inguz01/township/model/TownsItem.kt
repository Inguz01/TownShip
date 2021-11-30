package com.inguz01.township.model


import com.google.gson.annotations.SerializedName

data class TownsItem(
    @SerializedName("alt")
    val alt: String,
    @SerializedName("cali")
    val cali: Double,
    @SerializedName("descrip")
    val descrip: String,
    @SerializedName("info")
    val info: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("temp")
    val temp: String,
    @SerializedName("urlPicture")
    val urlPicture: String
)