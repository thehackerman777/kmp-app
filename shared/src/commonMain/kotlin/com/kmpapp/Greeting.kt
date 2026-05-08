package com.kmpapp

import kotlinx.serialization.Serializable

@Serializable
data class GreetingResponse(
    val message: String,
    val platform: String,
    val timestamp: Long
)

expect fun getPlatformName(): String

fun createGreeting(): GreetingResponse {
    return GreetingResponse(
        message = "¡Hola desde Kotlin Multiplatform!",
        platform = getPlatformName(),
        timestamp = System.currentTimeMillis()
    )
}
