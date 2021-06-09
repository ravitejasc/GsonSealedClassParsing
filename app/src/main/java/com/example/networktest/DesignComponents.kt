package com.example.networktest

import com.google.gson.annotations.SerializedName

data class Text(@SerializedName("text") val text: String)

//design_item_separator_v1
data class SeparatorComponentV1(
    @SerializedName("type")
    override val type: String,
    @SerializedName("data")
    val data: SeparatorData
) : DesignComponent() {

    data class SeparatorData(@SerializedName("height") val height: Float)

}

//design_item_section_header_v1
data class SectionHeaderComponentV1(
    @SerializedName("type")
    override val type: String,
    @SerializedName("data")
    val data: SectionHeaderData
) : DesignComponent() {

    data class SectionHeaderData(@SerializedName("leftText") val leftText: Text)

}

//design_list_view_v1
data class ListComponentV1(
    @SerializedName("type")
    override val type: String,
    @SerializedName("listMeta")
    val listMeta: ListMeta,
    @SerializedName("data")
    val data: List<DesignComponent>
) : DesignComponent() {

    data class ListMeta(@SerializedName("orientation") val orientation: Int = 0)

}

//design_list_item_v1
data class ListItemComponentV1(
    @SerializedName("type")
    override val type: String,
    @SerializedName("height") val height: Float,
    @SerializedName("width") val width: Float,
) : DesignComponent()
