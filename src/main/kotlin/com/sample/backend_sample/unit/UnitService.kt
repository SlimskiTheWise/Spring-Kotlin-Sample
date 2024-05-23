package com.sample.backend_sample.unit

import com.sample.backend_sample.property.PropertyRepository
import com.sample.backend_sample.unit.response.UnitsResponseDto
import jakarta.persistence.EntityNotFoundException
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.usermodel.Workbook
import org.apache.poi.xssf.usermodel.XSSFWorkbook
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class UnitService(
    private val unitRepository: UnitRepository,
    private val propertyRepository: PropertyRepository
) {
    /**
     * Creates a list of units associated with the specified property
     * using data from the provided Excel file.
     *
     * @param propertyId
     * @param file
     * @throws EntityNotFoundException
     */
    fun createUnits(propertyId: Long, file: MultipartFile) {
        val property = propertyRepository.findById(propertyId)
            .orElseThrow { EntityNotFoundException("Property with id $propertyId not found") }

        val units: MutableList<Unit> = mutableListOf()

        val workbook: Workbook = XSSFWorkbook(file.inputStream)
        val worksheet: Sheet = workbook.getSheetAt(0)

        // the 0th row indicates the property names, therefore the index starts from 1
        for (i in 1 until worksheet.physicalNumberOfRows) {
            val row = worksheet.getRow(i)

            val block = row.getCell(0).numericCellValue.toInt().toString()
            val name = row.getCell(1).numericCellValue.toInt().toString()

            units.add(Unit(property = property, block = block, name = name))
        }
        unitRepository.saveAll(units)
    }

    fun findAllUnitsWithProperty(): List<UnitsResponseDto> {
        val units = unitRepository.findAllUnitsWithProperty()
        return units.map { unit ->
            UnitsResponseDto(unit.id, unit.name, unit.block, unit.property)
        }
    }
}