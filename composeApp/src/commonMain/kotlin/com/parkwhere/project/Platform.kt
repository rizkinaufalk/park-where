package com.parkwhere.project

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform