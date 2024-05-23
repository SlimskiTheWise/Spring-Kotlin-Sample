package com.sample.backend_sample.property.dto

import io.swagger.v3.oas.annotations.media.Schema

data class CreatePropertyDto(
    @field:Schema(
        name = "name",
        description = "Name of the property",
        example = "DNK village",
        required = true,
    )
    val name: String = "DNK village"
)
