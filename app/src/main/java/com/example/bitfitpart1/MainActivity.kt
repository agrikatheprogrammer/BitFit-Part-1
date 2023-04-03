package com.example.bitfitpart1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.SyncStateContract.Helpers.update
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.bitfitpart1.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

import com.example.bitfitpart1.BestSellerBooksFragment

var counter=0
var average=0
var total=0
class MainActivity : AppCompatActivity() {

    lateinit var flashcardDatabase: RowDatabase
    var allFlashcards=mutableListOf<Row>()

    private fun replaceFragment(articleListFragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.article_frame_layout, articleListFragment)
        fragmentTransaction.commit()
    }
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        flashcardDatabase =RowDatabase(this)
        allFlashcards = flashcardDatabase.getAllCards().toMutableList()

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root as View
        setContentView(view)
        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                val data: Intent? = result.data
                if (data != null) {
                    flashcardDatabase.insertCard(Row((data.getStringExtra("FOOD")!!),
                        data.getStringExtra("CALORIES")!!)
                    )
                    allFlashcards=flashcardDatabase.getAllCards().toMutableList()
                    counter++
                    total += data.getStringExtra("CALORIES")!!.toInt()
                    average=total/counter
                    val CAL=view.findViewById<TextView>(R.id.totalcalories)
                    val ENT=view.findViewById<TextView>(R.id.totalentries)
                    val AVG=view.findViewById<TextView>(R.id.average)
                    CAL.text= "TOTAL CALORIES: $total"
                    ENT.text="TOTAL ENTRIES: $counter"
                    AVG.text="AVERAGE: $average"
                }
            }

        val intent= Intent(this,secondactivity::class.java)
  
        val articleListFragment: Fragment = ArticleListFragment()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottom_navigation)

        // handle navigation selection
        bottomNavigationView.setOnItemSelectedListener { item ->
            lateinit var fragment: Fragment
            when (item.itemId) {
                R.id.action_schedules -> fragment = BestSellerBooksFragment(resultLauncher,intent, total,counter, average)
                R.id.action_favorites -> fragment = articleListFragment

            }
            replaceFragment(fragment)
            true

        }

        // Set default selection
        bottomNavigationView.selectedItemId = R.id.action_favorites
    }
}