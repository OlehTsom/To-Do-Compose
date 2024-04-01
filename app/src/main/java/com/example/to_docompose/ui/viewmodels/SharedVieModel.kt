package com.example.to_docompose.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.data.repository.ToDoRepository
import com.example.to_docompose.utils.Action
import com.example.to_docompose.utils.Constants.TITLE_MAX_LENGTH
import com.example.to_docompose.utils.RequestState
import com.example.to_docompose.utils.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedVieModel @Inject constructor(
    private val toDoRepository: ToDoRepository
) : ViewModel(){

    val action: MutableState<Action> = mutableStateOf(Action.NO_ACTION)

    private val id : MutableState<Int> = mutableIntStateOf(0)
    val title: MutableState<String> = mutableStateOf("")
    val description: MutableState<String> = mutableStateOf("")
    val priority: MutableState<Priority> = mutableStateOf(Priority.LOW)

    val searchAppBarState: MutableState<SearchAppBarState> =
        mutableStateOf(SearchAppBarState.CLOSED)
    val searchTextState: MutableState<String> =
        mutableStateOf("")

    private val _allTasksState =
        MutableStateFlow<RequestState<List<ToDoTask>>>(RequestState.Idle)
    val allTasks : StateFlow<RequestState<List<ToDoTask>>> =
        _allTasksState.asStateFlow()

    fun getAllTasks(){
        viewModelScope.launch {
            _allTasksState.emit(RequestState.Loading)
        }
        try {
            viewModelScope.launch {
                toDoRepository.getAllTasks.collect{
                    _allTasksState.emit(RequestState.Success(it))
                }
            }
        }catch (error: Exception){
            viewModelScope.launch {
                _allTasksState.emit(RequestState.Error(error))
            }
        }
    }

    private val _selectedTaskState:
        MutableStateFlow<ToDoTask?> = MutableStateFlow(null)
    val selectedTaskState = _selectedTaskState.asStateFlow()

    fun getSelectedSTask(taskId: Int){
        viewModelScope.launch {
            toDoRepository.getSelectedTask(taskId = taskId).collect{task  ->
                _selectedTaskState.emit(task)
            }
        }
    }

    private fun addTask(){
        viewModelScope.launch(Dispatchers.IO) {
            val task = ToDoTask(
                title = title.value,
                description = description.value,
                priority = priority.value
            )
            toDoRepository.addTask(toDoTask = task)
        }
    }

    fun handleDatabaseActions(action: Action){
        when(action){
            Action.ADD -> {
                addTask()
            }
            Action.UPDATE -> {

            }
            Action.DELETE -> {

            }
            Action.DELETE_ALL -> {

            }
            Action.UNDO -> {

            }
            else -> {

            }
        }
        this.action.value = Action.NO_ACTION
    }

    fun updateTaskFields(selectedTask: ToDoTask?){
        if (selectedTask != null){
            id.value = selectedTask.id
            title.value = selectedTask.title
            description.value = selectedTask.description
            priority.value = selectedTask.priority
        }else{
            id.value = 0
            title.value = ""
            description.value = ""
            priority.value = Priority.LOW
        }
    }

    fun updateTitle(newTitle: String){
        if (newTitle.length < TITLE_MAX_LENGTH){
            title.value = newTitle
        }
    }

    fun validateFields(): Boolean{
        return title.value.isNotEmpty() && description.value.isNotEmpty()
    }

}