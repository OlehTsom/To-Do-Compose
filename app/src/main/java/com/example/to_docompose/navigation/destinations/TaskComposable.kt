package com.example.to_docompose.navigation.destinations

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.ui.screens.task.TaskScreen
import com.example.to_docompose.ui.viewmodels.SharedVieModel
import com.example.to_docompose.utils.Action
import com.example.to_docompose.utils.Constants.TASK_ARGUMENT_KEY
import com.example.to_docompose.utils.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    sharedVieModel: SharedVieModel,
    navigateToListScreen: (Action) -> Unit
){
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY){
            type = NavType.IntType
        })
    ){navBackStackEntry ->
        val taskId = navBackStackEntry.arguments!!.getInt(TASK_ARGUMENT_KEY)
        sharedVieModel.getSelectedSTask(taskId)

        val selectedTask by sharedVieModel.selectedTaskState.collectAsState()

        LaunchedEffect(key1 = selectedTask){
            sharedVieModel.updateTaskFields(selectedTask)
        }

        TaskScreen(
            selectedTask = selectedTask,
            navigateToListScreen = navigateToListScreen,
            sharedVieModel = sharedVieModel
        )
    }
}