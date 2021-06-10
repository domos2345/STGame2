package vyvojmobilnychapk.project3.stgame2

import android.app.Activity
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import vyvojmobilnychapk.project3.stgame2.entities.Resource
import vyvojmobilnychapk.project3.stgame2.viewModels.ResourceListAdapter
import vyvojmobilnychapk.project3.stgame2.viewModels.ResourceViewModel
import vyvojmobilnychapk.project3.stgame2.viewModels.ResourceViewModelFactory

class MainActivity : AppCompatActivity() {


//    private val resourceViewModel: ResourceViewModel by viewModels {
//        ResourceViewModelFactory((application as MyApp).repository)
//    }

    //private val newResourceActivityRequestCode = 1



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //val recyclerView = findViewById<RecyclerView>(R.id.recyclerview)
        //val adapter = ResourceListAdapter()

        //recyclerView.adapter = adapter
        //recyclerView.layoutManager = LinearLayoutManager(this)

//        resourceViewModel.allResources.observe(this, Observer { resources ->
//            resources?.let { adapter.submitList(it) }
//        })

//        val fab = findViewById<FloatingActionButton>(R.id.fab)
//
//        fab.setOnClickListener {
//            val intent = Intent(this@MainActivity, NewResourceActivity::class.java)
//            startActivityForResult(intent, newResourceActivityRequestCode)
//        }
    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if (requestCode == newResourceActivityRequestCode && resultCode == Activity.RESULT_OK) {
//            data?.getStringExtra(NewResourceActivity.EXTRA_REPLY)?.let {
//                val res = Resource(it,it)
//                resourceViewModel.insert(res)
//            }
//        } else {
//            Toast.makeText(
//                applicationContext,
//                R.string.empty_not_saved,
//                Toast.LENGTH_LONG).show()
//        }
//    }
}