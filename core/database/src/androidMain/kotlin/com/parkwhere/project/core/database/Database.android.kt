package com.parkwhere.project.core.database

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.parkwhere.project.core.database.di.AppDatabase

fun getDatabaseBuilder(context: Context): RoomDatabase.Builder<AppDatabase> {
    val appContext = context.applicationContext
    val dbFile = appContext.getDatabasePath(AppDatabase.DB_NAME)

    return Room.databaseBuilder<AppDatabase>(
        context = appContext,
        name = dbFile.absolutePath
    )
}