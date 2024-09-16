package org.example.food.status

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform