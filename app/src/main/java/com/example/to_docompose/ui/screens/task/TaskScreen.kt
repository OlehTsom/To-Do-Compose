package com.example.to_docompose.ui.screens.task

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.ui.theme.getRandomsColorForTheme
import com.example.to_docompose.utils.Action
import com.example.to_docompose.utils.RequestState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit,
    containerColorMap: Map<Int,Int>
){
    Scaffold(
        topBar = {
            TaskAppTopBar(
                selectedTask = selectedTask,
                navigateToListScreen = navigateToListScreen,
                containerColorMap = containerColorMap
            )
        }
    ){paddingValues ->
        Box(
            modifier = androidx.compose.ui.Modifier
                .padding(paddingValues)
        ){
            TaskContent(
                title = "",
                onTitleChanged = {},
                description = "",
                onDescriptionChanged = {},
                priority = Priority.LOW,
                onPrioritySelected = {},
                backgroundColorMap = if (selectedTask != null) {
                    mapOf(selectedTask.itemColorDarkTheme to selectedTask.itemColorLightTheme)
                } else {
                    containerColorMap
                }
            )
        }
    }
}