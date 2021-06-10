package vyvojmobilnychapk.project3.stgame2.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "group_table")
data class Group(
    @PrimaryKey val id: Int,
    val nameToDisplay: String = "skupina $id"
) {
}