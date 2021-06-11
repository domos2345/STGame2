package vyvojmobilnychapk.project3.stgame2.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "group_territory_table",
    primaryKeys = ["groupId", "territoryId"],
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
        )
    ]
)
data class GroupTerritory(
    val groupId: Int,
    val territoryId: Int

)