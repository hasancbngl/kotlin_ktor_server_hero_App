package com.hasancbngl.repository

import com.hasancbngl.models.ApiResponse
import com.hasancbngl.models.Hero

interface HeroRepository {

    //map each page to list of heroes included in that page
    val heroes: Map<Int, List<Hero>>

    val page1: List<Hero>
    val page2: List<Hero>
    val page3: List<Hero>
    val page4: List<Hero>
    val page5: List<Hero>

    suspend fun getAllHeroes(page: Int = 1): ApiResponse
    suspend fun searchHeroes(name: String?): ApiResponse
}