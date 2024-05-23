package com.sample.backend_sample.auth.response

import io.swagger.v3.oas.annotations.media.Schema

data class LoginResponseDto(
    @field: Schema(description = "jwt access token")
    val accessToken: String
)