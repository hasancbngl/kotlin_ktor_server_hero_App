package com.hasancbngl.routes

import com.hasancbngl.models.ApiResponse
import com.hasancbngl.repository.HeroRepositoryAlternative
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllHeroesAlternative() {
    val heroRepositoryAlternative: HeroRepositoryAlternative by inject()

    get("/heroes/alt") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            val limit = call.request.queryParameters["limit"]?.toInt() ?: 4
            //require the page only be within 1-5 otherwise throw an exception
            val apiResponse = heroRepositoryAlternative.getAllHeroes(page, limit)
            call.respond(message = apiResponse, status = HttpStatusCode.OK)
        } catch (e: NumberFormatException) {
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Invalid Page.Only numbers allowed."
                ),
                status = HttpStatusCode.BadRequest
            )
        } catch (e: IllegalArgumentException) {
            call.respond(
                message = ApiResponse(
                    success = false,
                    message = "Page not found"
                ),
                status = HttpStatusCode.NotFound
            )
        }
    }
}