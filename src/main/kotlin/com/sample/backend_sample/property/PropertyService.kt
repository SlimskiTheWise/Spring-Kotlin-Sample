package com.sample.backend_sample.property

import com.sample.backend_sample.property.dto.CreatePropertyDto
import com.sample.backend_sample.property.response.CreatePropertyResponseDto
import org.springframework.stereotype.Service

@Service
class PropertyService(
    private val propertyRepository: PropertyRepository
) {
    fun create(dto: CreatePropertyDto): CreatePropertyResponseDto {
        val savedProperty = propertyRepository.save(Property(name = dto.name))
        return CreatePropertyResponseDto(savedProperty.id)
    }
}