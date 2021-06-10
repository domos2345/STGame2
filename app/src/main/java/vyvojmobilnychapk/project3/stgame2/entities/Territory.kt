package vyvojmobilnychapk.project3.stgame2.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "territory_table")
data class Territory(
    @PrimaryKey val id: Int,
    val numberOfEstates: Int,
    val isRadioactive: Boolean,
    val neighbours: List<Int>
)