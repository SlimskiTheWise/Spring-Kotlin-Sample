package com.sample.backend_sample.unit.response

import com.sample.backend_sample.property.Property

data class UnitsResponseDto (
    val id: Long,
    val name: String,
    val block: String,
    val property: Property
)
