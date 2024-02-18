package com.example.to_docompose.ui.screens.task

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.to_docompose.data.models.ToDoTask
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

    }
}