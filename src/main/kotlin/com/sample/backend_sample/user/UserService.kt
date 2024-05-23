package com.sample.backend_sample.user

import com.sample.backend_sample.user.dto.CreateUserDto
import com.sample.backend_sample.user.response.CreateUserResponse
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val encoder: PasswordEncoder
) {
    fun create(dto: CreateUserDto): CreateUserResponse {
        val isDuplicate: Boolean = userRepository.findByEmail(dto.email) != null

        if (isDuplicate) {
            throw IllegalStateException("Email '${dto.email}' already exists")
        }

        val savedUser = userRepository.save(User.from(dto, encoder))
        return CreateUserResponse(savedUser.id)
    }
}