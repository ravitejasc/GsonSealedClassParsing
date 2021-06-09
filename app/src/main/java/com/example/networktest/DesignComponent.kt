package com.example.networktest

import com.google.gson.typeadapters.RuntimeTypeAdapterFactory

sealed class DesignComponent {
    abstract val type: String
}

enum class DesignType(val type: String) {
    SEPARATOR("design_item_separator_v1"),
    SECTION_HEADER("design_item_section_header_v1"),
    LIST_VIEW("design_list_view_v1"),
    LIST_ITEM("design_list_item_v1"),
}

val runtimeTypeAdapterFactory: RuntimeTypeAdapterFactory<DesignComponent> by lazy {
    RuntimeTypeAdapterFactory
        .of(DesignComponent::class.java, "type")
        .registerSubtype(SeparatorComponentV1::class.java, DesignType.SEPARATOR.type)
        .registerSubtype(SectionHeaderComponentV1::class.java, DesignType.SECTION_HEADER.type)
        .registerSubtype(ListComponentV1::class.java, DesignType.LIST_VIEW.type)
        .registerSubtype(ListItemComponentV1::class.java, DesignType.LIST_ITEM.type)
}