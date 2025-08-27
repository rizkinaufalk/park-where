package com.parkwhere.project.core.database.di

import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Suppress("KotlinNoActualForExpect")
expect object AppDatabaseConstructor: RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase
}