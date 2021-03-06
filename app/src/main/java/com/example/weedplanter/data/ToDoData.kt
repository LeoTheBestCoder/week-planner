package com.example.weedplanter.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "todo_table")
@Parcelize
data class ToDoData(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var title: String?,
    var time: String?,
    var description: String?
): Parcelable