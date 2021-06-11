package vyvojmobilnychapk.project3.stgame2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import vyvojmobilnychapk.project3.stgame2.entities.GroupTerritory


@Dao
interface GroupTerritoryDao {
    @Query("SELECT * FROM group_territory_table ")
    fun getGroupTerritories(): Flow<List<GroupTerritory>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(groupTerritory: GroupTerritory)

    @Query("DELETE FROM group_territory_table")
    suspend fun deleteAll()
}