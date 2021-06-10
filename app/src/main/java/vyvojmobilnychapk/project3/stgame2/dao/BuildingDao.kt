package vyvojmobilnychapk.project3.stgame2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import vyvojmobilnychapk.project3.stgame2.entities.Building


@Dao
interface BuildingDao {

    @Query("SELECT * FROM building_table ORDER BY name ASC")
    fun getSortedBuildings(): Flow<List<Building>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(building: Building)

    @Query("DELETE FROM building_table")
    suspend fun deleteAll()
}