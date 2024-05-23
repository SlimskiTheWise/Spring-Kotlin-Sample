package com.sample.backend_sample.user

import com.sample.backend_sample.user.dto.CreateUserDto
import com.sample.backend_sample.user.response.CreateUserResponse
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "User")
@RequestMapping("/user")
@RestController
class UserController (
    private val userService: UserService
) {

    @PostMapping("sign-up")
    @Operation(summary = "Sign up user")
    fun create(@RequestBody dto: CreateUserDto): ResponseEntity<CreateUserResponse> {
        return ResponseEntity<CreateUserResponse>(userService.create(dto), HttpStatus.CREATED)
    }
}