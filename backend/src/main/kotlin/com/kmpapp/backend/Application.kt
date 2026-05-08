package com.kmpapp.backend

import com.kmpapp.createGreeting
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0") {
        install(ContentNegotiation) {
            json()
        }
        routing {
            get("/") {
                call.respond(mapOf("status" to "ok", "app" to "KMP Backend"))
            }
            get("/api/greeting") {
                call.respond(createGreeting())
            }
            get("/api/hello/{name}") {
                val name = call.parameters["name"] ?: "Mundo"
                call.respond(mapOf(
                    "message" to "¡Hola, $name!",
                    "from" to "Ktor Backend"
                ))
            }
        }
    }.start(wait = true)
}
