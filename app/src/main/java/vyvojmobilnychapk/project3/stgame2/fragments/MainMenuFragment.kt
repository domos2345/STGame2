package vyvojmobilnychapk.project3.stgame2.fragments

import android.app.AlertDialog
import android.content.Context
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
import vyvojmobilnychapk.project3.stgame2.MyApp
import vyvojmobilnychapk.project3.stgame2.R


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MainMenuFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainMenuFragment : Fragment(), View.OnClickListener {

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
        view.findViewById<Button>(R.id.gameButton).setOnClickListener {
            if(isFirstTime()){
                showDialog()
            }
            navController.navigate(R.id.action_mainMenuFragment_to_gameFragment)
        }
        view.findViewById<Button>(R.id.editGameButton).setOnClickListener(this)
        view.findViewById<Button>(R.id.settingsButton).setOnClickListener(this)

        if (isFirstTime()){
            showDialog()
        }
    }

    private fun isFirstTime(): Boolean {
        val sharedPreferences = MyApp.INSTANCE.getPreferences()
        return sharedPreferences.getBoolean("firstTime", true)

    }

    fun afterGroupNumberSaved() {
        navController.navigate(R.id.action_mainMenuFragment_to_gameFragment)

        val editor: SharedPreferences.Editor = MyApp.INSTANCE.getEditor()
        editor.putBoolean("firstTime", false)
        editor.commit()

    }

    override fun onClick(v: View?) {
        if (!isFirstTime()) {
            when (v!!.id) {

                R.id.editGameButton -> navController.navigate(R.id.action_mainMenuFragment_to_editGameFragment)
                R.id.gameButton -> navController.navigate(R.id.action_mainMenuFragment_to_settingsFragment)
            }
        } else {
            if (v!!.id == R.id.gameButton) {
                showDialog()
            } else {
                Toast.makeText(activity, "go to HRA first", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun showDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(activity)
        builder.setTitle("zadaj počet skupín")

// Set up the input

// Set up the input
        val input = EditText(activity)
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_CLASS_NUMBER
        builder.setView(input)

// Set up the buttons

// Set up the buttons
        builder.setPositiveButton("OK",
            DialogInterface.OnClickListener { dialog, which -> afterGroupNumberSaved() })
        builder.setNegativeButton("Cancel",
            DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        builder.show()
    }
}