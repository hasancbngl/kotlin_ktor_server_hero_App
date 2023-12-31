package com.hasancbngl.repository

import com.hasancbngl.models.ApiResponse
import com.hasancbngl.models.Hero

interface HeroRepositoryAlternative {
    val heroes: List<Hero>

    suspend fun getAllHeroes(page: Int = 1, limit: Int = 4): ApiResponse
    suspend fun searchHeroes(name: String?): ApiResponse
}