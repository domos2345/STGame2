package vyvojmobilnychapk.project3.stgame2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import vyvojmobilnychapk.project3.stgame2.entities.GroupResource

@Dao
interface GroupResourceDao {
    @Query("SELECT * FROM group_resource_table ORDER BY groupId ASC")
    fun getSortedGroupResources(): Flow<List<GroupResource>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(groupResource: GroupResource)

    @Query("DELETE FROM group_resource_table")
    suspend fun deleteAll()
}