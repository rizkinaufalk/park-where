package com.parkwhere.project.domain.repository

import com.parkwhere.project.data.di.datasources.local.entity.ParkingEntity
import kotlinx.coroutines.flow.Flow

interface ParkingRepository {
    suspend fun insertParkingToLocal(parking: ParkingEntity)
    suspend fun getLocalParkingById(id: Long): ParkingEntity
    suspend fun getLocalParkingHistory(): Flow<List<ParkingEntity>>
    suspend fun clearLocalParkingHistory()
}