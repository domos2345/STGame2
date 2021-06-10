package vyvojmobilnychapk.project3.stgame2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import vyvojmobilnychapk.project3.stgame2.entities.Reward

@Dao
interface RewardsDao {
    @Query("SELECT * FROM reward_table")
    fun getRewards(): Flow<List<Reward>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(reward: Reward)

    @Query("DELETE FROM reward_table")
    suspend fun deleteAll()
}