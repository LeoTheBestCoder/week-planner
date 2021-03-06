package com.example.weedplanter.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ToDoViewModel(application: Application) : AndroidViewModel(application) {
    private val toDoDao = ToDoDatabase.getDatabase(application).toDoDao()
    private val repository: ToDoRepository = ToDoRepository(toDoDao)
    val sortByTime: LiveData<List<ToDoData>> = toDoDao.sortByTime()
    val getAllData: LiveData<List<ToDoData>> = repository.getAllData

    fun insertData(toDoData: ToDoData) {
        Log.i("I", "ToDoData = $toDoData")
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.insertData(toDoData)
        }
    }

    fun updateData(toDoData: ToDoData) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.updateData(toDoData)
        }
    }

    fun deleteItem(id: Int) {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.deleteItem(id)
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.deleteAll()
        }
    }
    fun searchByIdDatabase(searchQuery: Int): LiveData<ToDoData> {
        return repository.searchByIdDatabase(searchQuery)
    }


    fun searchDatabase(searchQuery: String): LiveData<List<ToDoData>> {
        return repository.searchDatabase(searchQuery)
    }

    fun verifyData(title: String, time: String): Boolean {
        return !(title.isEmpty() || time.isEmpty())
    }

}