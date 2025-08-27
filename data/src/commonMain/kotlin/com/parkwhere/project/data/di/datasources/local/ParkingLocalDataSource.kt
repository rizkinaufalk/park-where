package com.parkwhere.project.data.di.datasources.local

import com.parkwhere.project.data.di.datasources.local.entity.ParkingEntity
import kotlinx.coroutines.flow.Flow

interface ParkingLocalDataSource {
    suspend fun insertParking(parking: ParkingEntity)
    suspend fun getParkingById(id: Long): ParkingEntity
    suspend fun getParkingHistory(): Flow<List<ParkingEntity>>
    suspend fun clearParkingHistory()
}