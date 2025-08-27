package com.parkwhere.project.data.di.datasources.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.parkwhere.project.data.di.datasources.local.entity.ParkingEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ParkingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertParking(parkingEntity: ParkingEntity)

    @Query("SELECT * FROM parking WHERE id = :id")
    suspend fun getParkingById(id: Long): ParkingEntity

    @Query("SELECT * FROM parking")
    suspend fun getAllParking(): Flow<List<ParkingEntity>>

    @Query("DELETE FROM parking")
    suspend fun clearParking()
}