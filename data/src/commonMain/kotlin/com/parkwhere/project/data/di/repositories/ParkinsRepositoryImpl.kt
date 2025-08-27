package com.parkwhere.project.data.di.repositories

import com.parkwhere.project.data.di.datasources.local.ParkingLocalDataSource
import com.parkwhere.project.data.di.datasources.local.entity.ParkingEntity
import com.parkwhere.project.domain.repository.ParkingRepository
import kotlinx.coroutines.flow.Flow

class ParkinsRepositoryImpl(
    private val local: ParkingLocalDataSource
): ParkingRepository {

    override suspend fun insertParkingToLocal(parking: ParkingEntity) {
        TODO("Not yet implemented")
    }

    override suspend fun getLocalParkingById(id: Long): ParkingEntity {
        TODO("Not yet implemented")
    }

    override suspend fun getLocalParkingHistory(): Flow<List<ParkingEntity>> {
        TODO("Not yet implemented")
    }

    override suspend fun clearLocalParkingHistory() {
        TODO("Not yet implemented")
    }
}