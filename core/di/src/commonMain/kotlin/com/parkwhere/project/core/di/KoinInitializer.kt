package com.parkwhere.project.core.di

import org.koin.core.context.startKoin

fun initKoin(){
    startKoin {
        modules(appModule)
    }
}