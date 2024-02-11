package com.example.to_docompose.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.data.repository.ToDoRepository
import com.example.to_docompose.utils.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedVieModel @Inject constructor(
    private val toDoRepository: ToDoRepository
) : ViewModel(){

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> =
        mutableStateOf("")

    private val _allTasksState =
        MutableStateFlow<List<ToDoTask>>(emptyList())
    val allTasks : StateFlow<List<ToDoTask>> =
        _allTasksState.asStateFlow()

    fun getAllTasks(){
        viewModelScope.launch {
            toDoRepository.getAllTasks.collect{
                _allTasksState.emit(it)
            }
        }
    }

}