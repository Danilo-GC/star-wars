package com.danilo.controller

import com.danilo.model.Planet
import com.danilo.service.PlanetService
import io.micronaut.http.HttpStatus
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(MockKExtension::class)
class PlanetControllerTest {

    @InjectMockKs
    lateinit var planetController: PlanetController

    @MockK
    lateinit var planetService: PlanetService

    lateinit var planet: Planet


    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        planet = Planet(1, "1234", "nublado", "montanhoso", false)
    }

    @Test
    fun `should Return Success When Get Planet By Id`() {
        every { planetService.getById(any()) }.returns(planet)
        val result = planetController.getById(planet.id)
        Assertions.assertEquals(result.body(), planet)
    }

    @Test
    fun `should Return Success When Creating New Planet`() {
        every { planetService.addPlanet(any()) }.returns(planet)
        val result = planetController.addPlanet(planet)
        Assertions.assertEquals(result.body(), planet)
    }

    @Test
    fun `should Return Success When Deleting Planet`() {
        every { planetService.deletePlanet(any()) }.returns(Unit)
        val result = planetController.deletePlanet(1L)
        Assertions.assertEquals(result.status, HttpStatus.NO_CONTENT)
    }


    @Test
    fun `should Return Success When Getting All Planets`() {
        val planetList = listOf(planet)
        every { planetService.getAll() }.returns(planetList)
        val result = planetController.getAll()
        Assertions.assertEquals(result.body(), planetList)
    }

    @Test
    fun `should Return Success When Updating Planet`() {
        every { planetService.updatePlanet(any(), any()) }.returns(planet)
        val result = planetController.updatePlanet(planet.id, planet)
        Assertions.assertEquals(result.body(), planet)
    }

}


