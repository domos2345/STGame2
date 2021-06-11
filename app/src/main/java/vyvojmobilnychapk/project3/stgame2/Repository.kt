package vyvojmobilnychapk.project3.stgame2

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import vyvojmobilnychapk.project3.stgame2.dao.*
import vyvojmobilnychapk.project3.stgame2.entities.Group
import vyvojmobilnychapk.project3.stgame2.entities.GroupResource
import vyvojmobilnychapk.project3.stgame2.entities.Resource
import kotlin.random.Random

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
    suspend fun insertResource(resource: Resource) {
        resourceDao.insert(resource)

    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertGroup(group:Group) {
        groupDao.insert(group)

    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertGroupResource(groupResource: GroupResource) {
        groupResourceDao.insert(groupResource)

    }

    fun initGroupResources(numberOfGroups: Int) {
         resourceDao.getSortedResources().map {list ->
             list.forEach { res->
                 for (i in 1..numberOfGroups) {
                     println(i)
                     insertGroup(Group(i,"skupina$i"))
                     insertGroupResource(GroupResource(i,res.name,i*10))
                 }
             }

         }


    }
}