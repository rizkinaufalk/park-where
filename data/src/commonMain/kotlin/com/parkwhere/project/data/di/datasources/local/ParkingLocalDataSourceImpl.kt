package com.parkwhere.project.data.di.datasources.local

import com.parkwhere.project.data.di.datasources.local.entity.ParkingEntity
import kotlinx.coroutines.flow.Flow

class ParkingLocalDataSourceImpl(
    private val local: ParkingDao
): ParkingLocalDataSource {
    override suspend fun insertParking(parking: ParkingEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getParkingById(id: Long): ParkingEntity {
        TODO("Not yet implemented")
    }

    override suspend fun getParkingHistory(): Flow<List<ParkingEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun clearParkingHistory() {
        TODO("Not yet implemented")
    }

}