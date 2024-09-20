package com.data.listitemapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.data.listitemapp.services.Item
import com.data.listitemapp.services.RetrofitInstance
import kotlinx.coroutines.launch

class ListItemsViewModel : ViewModel() {
    private val _items = MutableLiveData<List<Item>>()
    val items: LiveData<List<Item>> get() = _items

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            try {
                val fetchedItems = RetrofitInstance.api.getItems()
                
                val processedItems = fetchedItems
                    .filter { !it.name.isNullOrBlank() }
                    .sortedWith(compareBy({ it.listId }, { it.name }))
                _items.postValue(processedItems)
            } catch (e: Exception) {

            }
        }
    }
}
