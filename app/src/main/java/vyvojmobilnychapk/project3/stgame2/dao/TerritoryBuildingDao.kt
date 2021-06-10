package vyvojmobilnychapk.project3.stgame2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import vyvojmobilnychapk.project3.stgame2.entities.TerritoryBuilding

@Dao
interface TerritoryBuildingDao {
    @Query("SELECT * FROM territory_building_table ORDER BY groupId ASC")
    fun getSortedTerritoryBuildings(): Flow<List<TerritoryBuilding>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(territoryBuilding: TerritoryBuilding)

    @Query("DELETE FROM territory_building_table")
    suspend fun deleteAll()
}