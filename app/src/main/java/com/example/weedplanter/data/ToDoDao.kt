package com.example.weedplanter.data

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface ToDoDao {

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData() : LiveData<List<ToDoData>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(toDoData: ToDoData)

    @Update
    suspend fun updateData(toDoData: ToDoData)

    @Query("DELETE FROM todo_table WHERE id LIKE :Query")
    suspend fun deleteItem(Query: Int)

    @Query("DELETE FROM todo_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM todo_table WHERE title LIKE :searchQuery")
    fun searchDatabase(searchQuery: String) : LiveData<List<ToDoData>>

    @Query("SELECT * FROM todo_table WHERE id LIKE :searchQuery")
    fun searchByIdDatabase(searchQuery: Int) : LiveData<ToDoData>

    @Query("SELECT * FROM todo_table WHERE id LIKE :searchQuery")
    fun searchByIdsDatabase(searchQuery: Int) : ToDoData

    @Query("SELECT * FROM todo_table ORDER BY time")
    fun sortByTime(): LiveData<List<ToDoData>>
}