package com.danilo.service

import com.danilo.model.Planet
import com.danilo.repository.PlanetRepository
import com.danilo.service.impl.PlanetServiceImpl
import io.kotest.matchers.file.exist
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import java.util.*

@ExtendWith(MockKExtension::class)
class PlanetServiceTest {

    @InjectMockKs
    lateinit var planetServiceImpl: PlanetServiceImpl

    @MockK
    lateinit var planetRepository: PlanetRepository

    lateinit var planet: Planet

    @BeforeEach
    fun setUp() {
        MockKAnnotations.init(this)
        planet = Planet(1, "1234", "nublado", "montanhoso", false)
    }

    @Test
    fun `should Get Planet By Id`() {
        every { planetRepository.findById(any()) }.returns(Optional.of(planet))
        val result = planetServiceImpl.getById(planet.id)
        Assertions.assertEquals(result,planet)
    }

    @Test
    fun `should Get All Planets`() {
        val planetList = arrayListOf(planet)
        every { planetRepository.findAll() }.returns(planetList)
        val result = planetServiceImpl.getAll()
        Assertions.assertEquals(result,planetList)
    }

    @Test
    fun `should Create New Planet`() {
        every { planetRepository.save(any()) }.returns(planet)
        val result = planetServiceImpl.addPlanet(planet)
        Assertions.assertEquals(result,planet)
    }

    @Test
    fun `should Delete Planet`() {
        every { planetRepository.deleteById(any()) }.returns(Unit)
        val result = planetServiceImpl.deletePlanet(planet.id)
        Assertions.assertEquals(result, Unit)
    }

    @Test
    fun `should Edit Planet`() {
        every { planetRepository.existsById(any()) }.returns(true)
        every { planetRepository.update(any()) }.returns(planet)
        val result = planetServiceImpl.updatePlanet(planet.id,planet)
        Assertions.assertEquals(result,planet)
    }
}