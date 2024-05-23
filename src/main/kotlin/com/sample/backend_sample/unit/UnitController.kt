package com.sample.backend_sample.unit

import com.sample.backend_sample.unit.response.UnitsResponseDto
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile


@RestController
@Tag(name = "Unit")
@RequestMapping("/unit")
class UnitController(private val unitService: UnitService) {
    @PostMapping(consumes = ["multipart/form-data"])
    @Operation(
        summary = "Create units",
        description = "Read the attached Excel file and store its data in the unit table"
    )
    fun createUnits(@RequestParam propertyId: Long, @RequestParam("file") file: MultipartFile): ResponseEntity<Void> {
        unitService.createUnits(propertyId, file)
        return ResponseEntity(HttpStatus.OK)
    }

    @GetMapping
    @Operation(summary = "Get all units")
    fun findAllUnitsWithProperty(): ResponseEntity<List<UnitsResponseDto>> {
        return ResponseEntity<List<UnitsResponseDto>>(unitService.findAllUnitsWithProperty(), HttpStatus.OK)
    }
}