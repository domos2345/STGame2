package vyvojmobilnychapk.project3.stgame2.dialogs

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.text.InputType
import android.util.Log
import android.widget.EditText
import kotlinx.coroutines.launch
import vyvojmobilnychapk.project3.stgame2.MyApp
import vyvojmobilnychapk.project3.stgame2.R

class Dialogs {

    fun showNumberOfGroupsDialog(context: Context, firstTime: Boolean) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setTitle("zadaj počet skupín")


// Set up the input
        val input = EditText(context)
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_NORMAL
        builder.setView(input)

// Set up the buttons
        builder.setPositiveButton("OK",
            DialogInterface.OnClickListener { dialog, which ->
                finishNumberOfGroupsDialog(
                    input.text.toString().toInt(), firstTime, context
                )
            })
        builder.setNegativeButton("Cancel",
            DialogInterface.OnClickListener { dialog, which -> dialog.cancel() })

        builder.show()
    }

    fun afterGroupNumberSaved(numberOfGroups: Int) {

        val editor: SharedPreferences.Editor = MyApp.INSTANCE.getEditor()
        editor.putBoolean("firstTime", false)
        editor.commit()
        Log.d("DEBUG", "MyApp Coroutine... initGroupResources")
        MyApp.INSTANCE.applicationScope.launch {
            MyApp.INSTANCE.repository.initGroupResources(numberOfGroups)
        }

    }

    private fun finishNumberOfGroupsDialog(num: Int, firstTime: Boolean, context: Context) {

        Log.d("DEBUG", " ideme na vkladanie skupin afterGroupSaved")
        afterGroupNumberSaved(num)
        if (firstTime) {
            showMarketResourcesDialog(context)
        }
    }


    private fun showMarketResourcesDialog(context: Context) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(context)
        builder.setTitle("zadaj počet skupín")

// Set up the input
        val input = EditText(context)
// Specify the type of input expected; this, for example, sets the input as a password, and will mask the text
        input.inputType = InputType.TYPE_CLASS_NUMBER or InputType.TYPE_NUMBER_VARIATION_NORMAL
        builder.setView(input)

// Set up the buttons
        builder.setPositiveButton("OK",
            DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })
        builder.setNegativeButton("Cancel",
            DialogInterface.OnClickListener { dialog, which ->
                dialog.cancel()
            })

        builder.show()
    }
}