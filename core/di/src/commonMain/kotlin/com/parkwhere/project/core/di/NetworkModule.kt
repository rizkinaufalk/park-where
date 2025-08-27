package com.parkwhere.project.core.di

import com.parkwhere.project.core.network.di.createHttpClient
import org.koin.dsl.module

val networkModule = module {
    single { createHttpClient() }
}