package com.parkwhere.project.core.di

import com.parkwhere.project.core.database.di.AppDatabase
import com.parkwhere.project.core.database.di.AppDatabaseConstructor
import org.koin.dsl.module

val databaseModule = module {
    single<AppDatabase> {
        AppDatabaseConstructor.initialize()
    }

    single { get<AppDatabase>().parkingDao() }
}