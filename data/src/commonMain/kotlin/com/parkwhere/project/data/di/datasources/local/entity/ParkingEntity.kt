package com.parkwhere.project.data.di.datasources.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "parking")
data class ParkingEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val notes: String? = "",
    val photoUri: String,
    val lat: Double,
    val lng: Double,
    val price: Int,
    val timeStamp: Long
)