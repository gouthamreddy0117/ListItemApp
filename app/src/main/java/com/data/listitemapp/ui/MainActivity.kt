package com.data.listitemapp.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.data.listitemapp.R


class MainActivity : AppCompatActivity() {
    private lateinit var itemsAdapter: ListItemsAdapter
    private val viewModel: ListItemsViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_layout)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.items.observe(this) { items ->
            itemsAdapter = ListItemsAdapter(items)
            recyclerView.adapter = itemsAdapter
        }
    }
}


