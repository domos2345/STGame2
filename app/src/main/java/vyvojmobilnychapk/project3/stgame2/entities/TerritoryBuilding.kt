package vyvojmobilnychapk.project3.stgame2.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "territory_building_table",
    primaryKeys = ["groupId", "territoryId", "buildingName"],
    foreignKeys = [
        ForeignKey(
            entity = Group::class,
            parentColumns = ["id"],
            childColumns = ["groupId"]
        ),
        ForeignKey(
            entity = Territory::class,
            parentColumns = ["id"],
            childColumns = ["territoryId"]
        ),
        ForeignKey(
            entity = Building::class,
            parentColumns = ["name"],
            childColumns = ["buildingName"],

            )
    ]
)
data class TerritoryBuilding(
    val groupId: Int,
    val territoryId: Int,
    val buildingName: String,
    val number: Int
)