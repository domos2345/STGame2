package vyvojmobilnychapk.project3.stgame2

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import vyvojmobilnychapk.project3.stgame2.dao.*
import vyvojmobilnychapk.project3.stgame2.entities.*
import vyvojmobilnychapk.project3.stgame2.models.ResourceModel
import kotlin.reflect.KClass


@Database(
    entities = [
        Resource::class, Group::class, Building::class, Territory::class, BuildingResource::class,
        GroupResource::class, GroupTerritory::class, TerritoryBuilding::class,
        Market::class, Reward::class
    ],
    version = 5,
    exportSchema = false
)
@TypeConverters(Converters::class)
public abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun resourceDao(): ResourceDao
    abstract fun buildingDao(): BuildingDao
    abstract fun buildingResourceDao(): BuildingResourceDao
    abstract fun groupDao(): GroupDao
    abstract fun groupResourceDao(): GroupResourceDao
    abstract fun marketDao(): MarketDao
    abstract fun rewardsDao(): RewardsDao
    abstract fun territoryDao(): TerritoryDao
    abstract fun territoryBuildingDao(): TerritoryBuildingDao


    private class AppDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.resourceDao())
                }
            }
        }

        suspend fun populateDatabase(resourceDao: ResourceDao) {
            // Delete all content here.
            resourceDao.deleteAll()

            val sealedSubclasses =
                ResourceModel::class.sealedSubclasses.mapNotNull { it.objectInstance }
                    .forEach { res ->
                        resourceDao.insert(Resource(res.name, res.nameToDisplay))
                    }

//            // Add sample words.
//            var res = Resource("1Wood", "drevo")
//            resourceDao.insert(res)
//            res = Resource("2Brick", "tehly")
//            resourceDao.insert(res)
//            res = Resource("3Iron", "železo")
//            resourceDao.insert(res)
//            res = Resource("4People", "zamestnanci")
//            resourceDao.insert(res)
//            res = Resource("5Money", "peniaze")
//            resourceDao.insert(res)

        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppRoomDatabase? = null

        fun getDatabase(
            context: Context,
            scope: CoroutineScope
        ): AppRoomDatabase {

            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppRoomDatabase::class.java,
                    "database"
                ).fallbackToDestructiveMigration().addCallback(AppDatabaseCallback(scope)).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}

