package com.mikeh.littlelemon.api.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Created by Maycon Henrique on 26/01/2025.
 * maycon255@hotmail.com
 */

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String,
    @SerialName("description")
    val description: String,
    @SerialName("price")
    val price: Double,
    @SerialName("image")
    val image: String,
    @SerialName("category")
    val category: String,
) {
    fun toMenuItemRoom() = MenuItemRoom(
        id,
        title,
        description,
        price,
        image,
        category
    )
}

@Serializable
data class MenuNetworkData(
    @SerialName("menu")
    val menu: List<MenuItemNetwork>
)