package com.rohim.jetheroes.data

import com.rohim.jetheroes.model.Hero
import com.rohim.jetheroes.model.HeroesData

class HeroesRepository {
    fun getHeroes(): List<Hero> {
        return HeroesData.heroes
    }
    fun searchHeroes(query: String): List<Hero> {
        return HeroesData.heroes.filter {
            it.name.contains(query, ignoreCase = true)
        }
    }
}