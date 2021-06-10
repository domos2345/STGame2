package vyvojmobilnychapk.project3.stgame2

import android.app.Application
import android.content.SharedPreferences
import android.preference.PreferenceManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob


class MyApp : Application() {
    val preferences = "prefs"



    val applicationScope = CoroutineScope(SupervisorJob())

    // Using by lazy so the database and the repository are only created when they're needed
    // rather than when the application starts
    val database by lazy { AppRoomDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { Repository() }


    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    fun getEditor():SharedPreferences.Editor {
        return getSharedPreferences("prefs", MODE_PRIVATE).edit()
    }

    fun getPreferences():SharedPreferences{
        return getSharedPreferences("prefs", MODE_PRIVATE)
    }

//    inline fun <reified T> getPrefValue(key:String): T {
//        when (T::class.java) {
//            is Boolean ->
//        }
//    }

    companion object{
        lateinit var INSTANCE:MyApp
    }
}