package vyvojmobilnychapk.project3.stgame2

import android.util.Log
import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import vyvojmobilnychapk.project3.stgame2.dao.*
import vyvojmobilnychapk.project3.stgame2.entities.Group
import vyvojmobilnychapk.project3.stgame2.entities.GroupResource
import vyvojmobilnychapk.project3.stgame2.entities.Resource
import vyvojmobilnychapk.project3.stgame2.models.ResourceModel
import kotlin.random.Random

// Declares the DAO as a private property in the constructor. Pass in the DAO
// instead of the whole database, because you only need access to the DAO
class Repository() {
    val myApp = MyApp.INSTANCE
    val database = myApp.database
    val resourceDao: ResourceDao = database.resourceDao()
    val buildingDao: BuildingDao = database.buildingDao()
    val buildingResourceDao: BuildingResourceDao = database.buildingResourceDao()
    val groupDao: GroupDao = database.groupDao()
    val groupResourceDao: GroupResourceDao = database.groupResourceDao()
    val territoryDao: TerritoryDao = database.territoryDao()
    val territoryBuildingDao: TerritoryBuildingDao = database.territoryBuildingDao()
    val rewardsDao: RewardsDao = database.rewardsDao()
    val marketDao: MarketDao = database.marketDao()

    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.

    val allResources: LiveData<List<Resource>> = resourceDao.getSortedResources()


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
    suspend fun getResources(): LiveData<List<Resource>> {
        return resourceDao.getSortedResources()

    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertGroup(group: Group) {
        groupDao.insert(group)

    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insertGroupResource(groupResource: GroupResource) {
        groupResourceDao.insert(groupResource)

    }

    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    fun getAllGroupResources() {
        groupResourceDao.getSortedGroupResourcesList().forEach { grs ->
            Log.d("DEBUG", grs.toString())
        }
    }

    fun getAllGrs() {
        MyApp.INSTANCE.applicationScope.launch {
            getAllGroupResources()
        }
    }


    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun initGroupResources(numberOfGroups: Int) {
        Log.d("DEBUG", "getAllGroupResources")
        val sealedSubclasses =
            ResourceModel::class.sealedSubclasses.mapNotNull { it.objectInstance }
                .forEach { res ->
                    Log.d("DEBUG_ROOM", res.toString())
                    resourceDao.insert(Resource(res.name, res.nameToDisplay,false))
                }
        val ress: List<Resource> = resourceDao.getSortedResourcesList()
        // val liveress :List<Resource> = getResources().value!!
        Log.d("DEBUG", numberOfGroups.toString())
        Log.d("DEBUG", ress.size.toString())
        // Log.d("DEBUG", liveress.size.toString())
        resourceDao.getSortedResourcesList().forEach { res ->

            for (i in 1..numberOfGroups) {
                println(i)
                insertGroup(Group(i, "skupina$i"))
                insertGroupResource(GroupResource(i, res.name, i * 10))
            }
        }
    }


}