package com.rcl.connector.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HouseModel (
    @SerialName("house_id") val houseId: String? = null,
    @SerialName("house") val house: String? = null
)