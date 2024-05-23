package com.sample.backend_sample.auth

import com.sample.backend_sample.auth.dto.LoginDto
import com.sample.backend_sample.auth.response.LoginResponseDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Tag(name = "Auth")
@RequestMapping("/auth")
class AuthController(
    private val authService: com.sample.backend_sample.auth.AuthService
) {
    @PostMapping("/login")
    @Operation(summary = "Authenticates user")
    fun authenticate(@RequestBody dto: com.sample.backend_sample.auth.dto.LoginDto): ResponseEntity<com.sample.backend_sample.auth.response.LoginResponseDto> {
        return ResponseEntity.ok(authService.authenticate(dto))
    }
}