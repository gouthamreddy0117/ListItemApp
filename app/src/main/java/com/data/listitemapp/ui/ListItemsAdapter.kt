package com.data.listitemapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.data.listitemapp.R
import com.data.listitemapp.services.Item

class ListItemsAdapter(private val items: List<Item>) : RecyclerView.Adapter<ListItemsAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val listIdTextView: TextView = view.findViewById(R.id.listIdTextView)
        val nameTextView: TextView = view.findViewById(R.id.nameTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        holder.listIdTextView.text = "listId: "+ item.listId.toString()
        holder.nameTextView.text ="name: "+ item.name
    }

    override fun getItemCount() = items.size
}

