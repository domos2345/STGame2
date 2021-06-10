package vyvojmobilnychapk.project3.stgame2

import androidx.room.TypeConverter
import com.google.gson.Gson

class Converters {

    private val gson = Gson()

    @TypeConverter
    fun listToJson(value: List<Int>?) = gson.toJson(value)

    @TypeConverter
    fun jsonToList(value: String): List<Int>? = gson.fromJson(value, Array<Int>::class.java).toList()
}