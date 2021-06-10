package vyvojmobilnychapk.project3.stgame2.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "resource_table")
data class Resource(
    @PrimaryKey val name: String,
    val nameToDisplay: String
)