package com.parkwhere.project.core.di

import androidx.room.Room
import androidx.room.RoomDatabase
import com.parkwhere.project.core.database.di.AppDatabase
import com.parkwhere.project.core.database.di.AppDatabaseConstructor
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val databaseModule = module {
    single<AppDatabase> {
        AppDatabaseConstructor.initialize()
    }

    single { get<AppDatabase>().parkingDao() }
}