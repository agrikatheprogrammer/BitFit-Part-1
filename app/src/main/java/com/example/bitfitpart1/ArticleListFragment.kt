package com.example.bitfitpart1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ArticleListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
lateinit var cards: RecyclerView
class ArticleListFragment : Fragment() {


    lateinit var flashcardDatabase: RowDatabase
    var allFlashcards=mutableListOf<Row>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Change this statement to store the view in a variable instead of a return statement
        val view = inflater.inflate(R.layout.fragment_article_list, container, false)
        cards=view.findViewById(R.id.article_recycler_view)

        flashcardDatabase =RowDatabase(view.context)
        allFlashcards = flashcardDatabase.getAllCards().toMutableList()
        val theadapter= Adapter(view.context, allFlashcards)
        cards.adapter=theadapter
        cards.layoutManager=LinearLayoutManager(view.context)

        return view
    }




}