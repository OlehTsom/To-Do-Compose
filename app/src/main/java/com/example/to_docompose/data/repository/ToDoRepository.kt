package com.example.to_docompose.data.repository

import com.example.to_docompose.data.ToDoDao
import com.example.to_docompose.data.models.ToDoTask
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
@ViewModelScoped
class ToDoRepository @Inject constructor(
    private val toDoDao: ToDoDao
){
    val getAllTasks : Flow<List<ToDoTask>> = toDoDao.getAllTasks()
    val sortedByLowPriority : Flow<List<ToDoTask>> = toDoDao.sortedByLowPriority()
    val sortedByHighPriority : Flow<List<ToDoTask>> = toDoDao.sortedByHighPriority()

    fun getSelectedTask(taskId: Int) : Flow<ToDoTask>{
        return toDoDao.getSelectedTask(taskId = taskId)
    }

    suspend fun addTask(toDoTask: ToDoTask){
        toDoDao.addTask(task = toDoTask)
    }

    suspend fun updateTask(toDoTask: ToDoTask){
        toDoDao.updateTask(task = toDoTask)
    }

    suspend fun deleteTask(toDoTask: ToDoTask){
        toDoDao.deleteTask(task = toDoTask)
    }

    suspend fun deleteAllTasks(){
        toDoDao.deleteAllTasks()
    }

    fun searchDatabase(searchQuery: String) : Flow<List<ToDoTask>> {
        return toDoDao.searchDatabase(searchQuery = searchQuery)
    }

}