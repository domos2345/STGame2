package vyvojmobilnychapk.project3.stgame2.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "reward_table",
    primaryKeys = ["name", "place", "resourceName"],
    foreignKeys = [
        ForeignKey(
            entity = Resource::class,
            parentColumns = ["name"],
            childColumns = ["resourceName"]
        )
    ]
)
data class Reward(
    val name: String,
    val place: Int,
    val resourceName: String,
    val number: Int
)