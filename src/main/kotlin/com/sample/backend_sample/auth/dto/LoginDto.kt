package com.sample.backend_sample.auth.dto

import io.swagger.v3.oas.annotations.media.Schema

data class LoginDto(
    @field: Schema(
        name = "email",
        description = "used when logging in",
        example = "email@example.com"
    )
    val email: String,

    @field: Schema(name = "password", example = "password")
    val password: String,
)