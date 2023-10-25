package com.cstian23.loginsignin.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cstian23.loginsignin.R
import com.cstian23.loginsignin.data.remote.ExercisesItem

class MainAdapter(var context: Context, var list: List<ExercisesItem>): RecyclerView.Adapter<MainAdapter.ViewHolder>() {
    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.name_rv)
        val difficulty: TextView = view.findViewById(R.id.difficulty_rv)
        val instructions: TextView = view.findViewById(R.id.instructions_rv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.difficulty.text = list[position].difficulty
        holder.instructions.text = list[position].instructions
    }
}