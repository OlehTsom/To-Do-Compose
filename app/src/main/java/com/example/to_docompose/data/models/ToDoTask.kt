package com.example.to_docompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.to_docompose.utils.Constants.DATABASE_TABLE_NAME
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Entity(tableName = DATABASE_TABLE_NAME)
data class ToDoTask(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority,
    val dateAdded: String = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date())
)