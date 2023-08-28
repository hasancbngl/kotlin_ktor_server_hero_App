package com.hasancbngl.plugins

import com.hasancbngl.routes.getAllHeroes
import com.hasancbngl.routes.getAllHeroesAlternative
import com.hasancbngl.routes.root
import com.hasancbngl.routes.searchHeroes
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*
import java.io.File

fun Application.configureRouting() {
    routing {
        //root '/' endpoint
        root()
        getAllHeroes()
        getAllHeroesAlternative()
        searchHeroes()
        //specify the static content for images to be accessible from url
        staticResources("/images", "images"){}
    }
}
