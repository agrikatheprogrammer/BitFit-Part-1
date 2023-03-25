package com.example.bitfitpart1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    lateinit var flashcardDatabase: RowDatabase
    var allFlashcards=mutableListOf<Row>()
    private lateinit var cards: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        cards=findViewById(R.id.rv)

        flashcardDatabase =RowDatabase(this)
        allFlashcards = flashcardDatabase.getAllCards().toMutableList()
        val theadapter= Adapter(this, allFlashcards)
        cards.adapter=theadapter
        cards.layoutManager=LinearLayoutManager(this)
        val resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                val data: Intent? = result.data
                if (data != null) {
                    flashcardDatabase.insertCard(Row((data.getStringExtra("FOOD")!!),
                        data.getStringExtra("CALORIES")!!)
                    )
                    allFlashcards=flashcardDatabase.getAllCards().toMutableList()
                    theadapter.notifyDataSetChanged()
                }
            }
        val ineedabutton=findViewById<Button>(R.id.button)
        ineedabutton.setOnClickListener() {
            resultLauncher.launch(Intent(this,secondactivity::class.java))
        }
    }
}