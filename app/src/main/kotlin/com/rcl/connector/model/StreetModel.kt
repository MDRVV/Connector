package com.rcl.connector.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StreetModel (
    @SerialName("street_id") val streetId: String? = null,
    @SerialName("street") val street: String? = null
)