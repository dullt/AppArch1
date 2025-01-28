package com.itera.erlenste.apparch1.data.model

import kotlinx.serialization.Serializable

@Serializable
data class AgeResponse(
    val count: Int,
    val name: String,
    val age: Int
)