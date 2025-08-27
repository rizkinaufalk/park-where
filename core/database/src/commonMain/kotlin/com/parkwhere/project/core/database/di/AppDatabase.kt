package com.parkwhere.project.core.database.di

import androidx.room.ConstructedBy
import androidx.room.Database
import androidx.room.RoomDatabase
import com.parkwhere.project.data.di.datasources.local.ParkingDao
import com.parkwhere.project.data.di.datasources.local.entity.ParkingEntity

@Database(
    entities = [
        ParkingEntity::class
    ],
    version = 1,
    exportSchema = true
)
@ConstructedBy(AppDatabaseConstructor::class)
abstract class AppDatabase : RoomDatabase(){

    abstract fun parkingDao(): ParkingDao

    companion object{
        const val DB_NAME = "book.db"
    }
}