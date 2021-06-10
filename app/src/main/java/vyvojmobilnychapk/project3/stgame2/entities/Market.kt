package vyvojmobilnychapk.project3.stgame2.entities

import androidx.room.Entity
import androidx.room.ForeignKey

@Entity(
    tableName = "market_table",
    primaryKeys = ["phase", "res1", "res2"],
    foreignKeys = [
        ForeignKey(
            entity = Resource::class,
            parentColumns = ["name"],
            childColumns = ["res1"]
        ),
        ForeignKey(
            entity = Resource::class,
            parentColumns = ["name"],
            childColumns = ["res2"]
        ),


    ]
)
data class Market(
    val phase: Int,
    val res1: String,
    val res1Course: Int,
    val res2: String,
    val res2Course: Int,
)