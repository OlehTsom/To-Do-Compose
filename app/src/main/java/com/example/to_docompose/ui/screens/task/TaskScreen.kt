package com.example.to_docompose.ui.screens.task

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.ui.theme.getRandomsColorForTheme
import com.example.to_docompose.ui.viewmodels.SharedVieModel
import com.example.to_docompose.utils.Action
import com.example.to_docompose.utils.RequestState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    sharedVieModel: SharedVieModel,
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
){

    val title: String by sharedVieModel.title
    val description: String by sharedVieModel.description
    val priority: Priority by sharedVieModel.priority

    Scaffold(
        topBar = {
            TaskAppTopBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen
            )
        }
    ){paddingValues ->
        Box(
            modifier = androidx.compose.ui.Modifier
                .padding(paddingValues)
        ){
            TaskContent(
                title = title,
                onTitleChanged = {title ->
                    sharedVieModel.title.value = title
                },
                description = description,
                onDescriptionChanged = {description ->
                    sharedVieModel.description.value = description
                },
                priority = priority,
                onPrioritySelected = {priority ->
                    sharedVieModel.priority.value = priority
                }
            )
        }
    }
}