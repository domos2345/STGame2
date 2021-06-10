package vyvojmobilnychapk.project3.stgame2.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "building_table")
data class Building(
    @PrimaryKey val name: String,
    val nameToDisplay: String,
    val points: Int,


    ) {

}