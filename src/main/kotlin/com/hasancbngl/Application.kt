package com.hasancbngl

import io.ktor.server.application.*
import com.hasancbngl.plugins.*
import configureKoin

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused")
fun Application.module() {
    configureKoin()
    configureSerialization()
    configureMonitoring()
    configureRouting()
    configureDefaultHeaders()
    configureStatusPages()
}
