package com.gkreduction.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class SubtopicRemote(
    @SerialName("id") val id: Int?,
    @SerialName("name") val name: String?,
)
