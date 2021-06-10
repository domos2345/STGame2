package vyvojmobilnychapk.project3.stgame2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import vyvojmobilnychapk.project3.stgame2.entities.Group

@Dao
interface GroupDao {
    @Query("SELECT * FROM group_table ORDER BY id ASC")
    fun getSortedGroups(): Flow<List<Group>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(group: Group)

    @Query("DELETE FROM group_table")
    suspend fun deleteAll()
}