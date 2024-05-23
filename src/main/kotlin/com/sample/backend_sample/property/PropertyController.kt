package com.sample.backend_sample.property

import com.sample.backend_sample.property.dto.CreatePropertyDto
import com.sample.backend_sample.property.response.CreatePropertyResponseDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@Tag(name = "Property")
@RequestMapping("/property")
class PropertyController(
    private val propertyService: PropertyService
) {
    @PostMapping
    @Operation(summary = "Creates a new property named 'DNK village' by default")
    fun create(@RequestBody dto: CreatePropertyDto): ResponseEntity<CreatePropertyResponseDto> {
         return ResponseEntity<CreatePropertyResponseDto>(propertyService.create(dto), HttpStatus.CREATED)
    }
}