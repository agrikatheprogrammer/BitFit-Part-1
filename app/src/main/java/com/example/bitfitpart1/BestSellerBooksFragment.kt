package com.example.bitfitpart1


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.ActivityResultLauncher
import androidx.fragment.app.Fragment
import androidx.fragment.app.findFragment
import androidx.recyclerview.widget.LinearLayoutManager
import org.w3c.dom.Text


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [BestSellerBooksFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class BestSellerBooksFragment(private val resultLauncher: ActivityResultLauncher<Intent>,private val intent: Intent, private val
calories: Int, private val total: Int, private val average: Int) : Fragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val button=view.findViewById<Button>(R.id.button)

        button.setOnClickListener() {
            resultLauncher.launch(intent)
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_best_seller_books, container, false)
        val CAL=view.findViewById<TextView>(R.id.totalcalories)
        val ENT=view.findViewById<TextView>(R.id.totalentries)
        val AVG=view.findViewById<TextView>(R.id.average)
        CAL.text= "TOTAL CALORIES: $calories"
        ENT.text="TOTAL ENTRIES: $total"
        AVG.text="AVERAGE: $average"
        return view
    }

}