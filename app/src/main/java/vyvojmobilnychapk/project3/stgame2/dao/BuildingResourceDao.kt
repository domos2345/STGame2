package vyvojmobilnychapk.project3.stgame2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import vyvojmobilnychapk.project3.stgame2.entities.BuildingResource

@Dao
interface BuildingResourceDao {

    @Query("SELECT * FROM building_resource_table ORDER BY buildingName ASC")
    fun getSortedBuildingResources(): Flow<List<BuildingResource>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(buildingResource: BuildingResource)

    @Query("DELETE FROM building_resource_table")
    suspend fun deleteAll()
}