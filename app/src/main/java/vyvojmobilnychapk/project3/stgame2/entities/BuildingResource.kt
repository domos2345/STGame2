package vyvojmobilnychapk.project3.stgame2.entities

import androidx.room.*

@Entity(
    tableName = "building_resource_table",
    indices = [Index(value = ["buildingName", "resourceName"], unique = true)],
    foreignKeys = [ForeignKey(
        entity = Building::class,
        parentColumns = ["name"],
        childColumns = ["buildingName"]
    ),
        ForeignKey(
            entity = Resource::class,
            parentColumns = ["name"],
            childColumns = ["resourceName"]
        )]
)
data class BuildingResource(
    @PrimaryKey val id: Int,
    val buildingName: String,
    val resourceName: String,
    val cost: Int,
    val profit: Int,
    val profitInstant: Int

)

data class BuildingResourceWithResource(
    @Embedded val buildingResource: BuildingResource,
    @Relation(parentColumn = "resourceName", entityColumn = "name", entity = Resource::class)
    val resource: Set<Resource> // one single resource
)

data class BuildingWithBuildingResources(
    @Embedded val building: Building,
    @Relation(
        parentColumn = "name",
        entityColumn = "buildingName",
        entity = BuildingResource::class
    )
    val buildingResources: List<BuildingResourceWithResource>
)