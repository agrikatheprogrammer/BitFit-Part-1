package com.example.bitfitpart1

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

private const val TAG="Aggy's Adapter"
class Adapter(private val context : Context, private val rows: List<Row>) :
    RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Log.i(TAG, "onCreateViewHolder")
        val view = LayoutInflater.from(context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val show=rows[position]
        holder.bind(show)
    }
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {
        private val calories = itemView.findViewById<TextView>(R.id.calories)
        private val food = itemView.findViewById<TextView>(R.id.food)

        init {
            itemView.setOnClickListener(this)
        }
        fun bind(rowZ:Row) {
            calories.text = rowZ.calories
            food.text = rowZ.food
        }
        override fun onClick(p0: View?) {
            val tvshow = rows[adapterPosition]
            Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return rows.size
    }
}