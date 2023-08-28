package com.hasancbngl.routes

import com.hasancbngl.models.ApiResponse
import com.hasancbngl.repository.HeroRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.ktor.ext.inject

fun Route.getAllHeroes() {
    val heroRepository: HeroRepository by inject()

    get("/heroes") {
        try {
            val page = call.request.queryParameters["page"]?.toInt() ?: 1
            //require the page only be within 1-5 otherwise throw an exception
            require(page in 1..5)
            val apiResponse = heroRepository.getAllHeroes(page)
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