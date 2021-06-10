package vyvojmobilnychapk.project3.stgame2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import vyvojmobilnychapk.project3.stgame2.entities.Territory


@Dao
interface TerritoryDao {
    @Query("SELECT * FROM territory_table ORDER BY id ASC")
    fun getSortedTerritories(): Flow<List<Territory>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(territory: Territory)

    @Query("DELETE FROM territory_table")
    suspend fun deleteAll()
}
