package vyvojmobilnychapk.project3.stgame2

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import vyvojmobilnychapk.project3.stgame2.dao.*
import vyvojmobilnychapk.project3.stgame2.entities.Resource

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class Repository() {
    val myApp = MyApp.INSTANCE
    val database = myApp.database
    val resourceDao: ResourceDao = database.resourceDao()
    val buildingDao: BuildingDao = database.buildingDao()
    val buildingResourceDao:BuildingResourceDao = database.buildingResourceDao()
    val groupDao: GroupDao = database.groupDao()
    val groupResourceDao: GroupResourceDao = database.groupResourceDao()
    val territoryDao:TerritoryDao = database.territoryDao()
    val territoryBuildingDao: TerritoryBuildingDao = database.territoryBuildingDao()
    val rewardsDao: RewardsDao = database.rewardsDao()
    val marketDao: MarketDao = database.marketDao()

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.

    val allResources: Flow<List<Resource>> = resourceDao.getSortedResources()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(resource: Resource) {
        resourceDao.insert(resource)

    }
}