package vyvojmobilnychapk.project3.stgame2.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import vyvojmobilnychapk.project3.stgame2.entities.Resource

@Dao
interface ResourceDao {

    @Query("SELECT * FROM resource_table ORDER BY name ASC")
    fun getSortedResources(): LiveData<List<Resource>>

    @Query("SELECT * FROM resource_table ORDER BY name ASC")
    fun getSortedResourcesList(): List<Resource>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(resource: Resource)

    @Query("DELETE FROM resource_table")
    suspend fun deleteAll()
}