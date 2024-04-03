package com.example.to_docompose.navigation.destinations

import android.util.Log
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.to_docompose.ui.screens.list.ListScreen
import com.example.to_docompose.ui.viewmodels.SharedVieModel
import com.example.to_docompose.utils.Action
import com.example.to_docompose.utils.Constants.LIST_ARGUMENT_KEY
import com.example.to_docompose.utils.Constants.LIST_SCREEN
import com.example.to_docompose.utils.toAction

fun NavGraphBuilder.listComposable(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedVieModel: SharedVieModel
){
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY){
            type = NavType.StringType
        })
    ){navBackStackEntry ->
        val action = navBackStackEntry.arguments?.getString(LIST_ARGUMENT_KEY).toAction()

        var checkAction by rememberSaveable { mutableStateOf(Action.NO_ACTION) }

        LaunchedEffect(key1 = checkAction){
            if (action != checkAction){
                checkAction = action
                sharedVieModel.action.value = action
            }
        }

        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen,
            sharedVieModel = sharedVieModel
        )
    }
}