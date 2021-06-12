package vyvojmobilnychapk.project3.stgame2.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.coroutines.launch
import vyvojmobilnychapk.project3.stgame2.MyApp
import vyvojmobilnychapk.project3.stgame2.R
import vyvojmobilnychapk.project3.stgame2.dialogs.Dialogs


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainMenuFragment : Fragment() {

    lateinit var navController: NavController

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        //GAME
        view.findViewById<Button>(R.id.gameButton).setOnClickListener {
            if (isFirstTime()) {
                Dialogs().showNumberOfGroupsDialog(this.requireContext(),true)
            }
            navController.navigate(R.id.action_mainMenuFragment_to_gameFragment)
        }
        //EDIT GAME
        view.findViewById<Button>(R.id.editGameButton).setOnClickListener {
            if (isFirstTime()) {
                Toast.makeText(activity, "go to HRA first", Toast.LENGTH_SHORT).show()
            } else {
                navController.navigate(R.id.action_mainMenuFragment_to_editGameFragment)
            }
        }
        //SETTINGS
        view.findViewById<Button>(R.id.settingsButton).setOnClickListener {
            if (isFirstTime()) {
                Toast.makeText(activity, "go to HRA first", Toast.LENGTH_SHORT).show()
            } else {
                navController.navigate(R.id.action_mainMenuFragment_to_settingsFragment)
                MyApp.INSTANCE.repository.getAllGrs()
            }
        }

        if (isFirstTime()) {
            Dialogs().showNumberOfGroupsDialog(this.requireContext(),true)
        }
    }

    private fun isFirstTime(): Boolean {
        val sharedPreferences = MyApp.INSTANCE.getPreferences()
        return sharedPreferences.getBoolean("firstTime", true)
    }





}