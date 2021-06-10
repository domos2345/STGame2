package vyvojmobilnychapk.project3.stgame2.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow
import vyvojmobilnychapk.project3.stgame2.entities.Market

@Dao
interface MarketDao {
    @Query("SELECT * FROM market_table ORDER BY phase ASC")
    fun getSortedMarkets(): Flow<List<Market>>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(market: Market)

    @Query("DELETE FROM market_table")
    suspend fun deleteAll()
}