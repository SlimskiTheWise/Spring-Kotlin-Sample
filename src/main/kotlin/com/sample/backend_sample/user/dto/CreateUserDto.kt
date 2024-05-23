package com.sample.backend_sample.user.dto

import io.swagger.v3.oas.annotations.media.Schema

data class CreateUserDto(
    @field: Schema(
        name = "email",
        description = "used when logging in",
        example = "email@example.com"
    )
    val email: String,

    @field: Schema(name = "password", example = "password" )
    val password: String,

    @field: Schema(
        name = "name",
        description = "name of a user",
        example = "John"
    )
    val name: String
)
