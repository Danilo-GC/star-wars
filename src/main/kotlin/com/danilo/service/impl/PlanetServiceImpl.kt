package com.danilo.service.impl

import com.danilo.model.Planet
import com.danilo.repository.PlanetRepository
import com.danilo.service.PlanetService
import io.micronaut.http.HttpResponse
import java.lang.Exception
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PlanetServiceImpl(private val planetRepository: PlanetRepository): PlanetService {

    override fun getById(id: Long): Planet? {
      return this.planetRepository.findById(id).orElse(null)
    }

    override fun getAll(): List<Planet> {
        return this.planetRepository.findAll()
    }

    override fun addPlanet(planet: Planet): Planet {
        return this.planetRepository.save(planet)
        }

    override fun updatePlanet(id: Long, planet: Planet) {
       this.planetRepository.update(planet)
    }

    override fun deletePlanet(id: Long) {
      return this.planetRepository.deleteById(id)
    }
}