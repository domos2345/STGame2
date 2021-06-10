package vyvojmobilnychapk.project3.stgame2.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "group_resource_table",
    primaryKeys = ["groupId", "resourceName"],
    foreignKeys = [
        ForeignKey(
            entity = Group::class,
            parentColumns = ["id"],
            childColumns = ["groupId"]
        ),
        ForeignKey(
            entity = Resource::class,
            parentColumns = ["name"],
            childColumns = ["resourceName"]
        )
    ]
)
data class GroupResource(
    val groupId: Int,
    val resourceName: String,
    val number: Int
)