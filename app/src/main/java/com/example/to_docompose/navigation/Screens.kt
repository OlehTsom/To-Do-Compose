package com.example.to_docompose.navigation

import androidx.navigation.NavHostController
import com.example.to_docompose.utils.Action
import com.example.to_docompose.utils.Constants.LIST_SCREEN


class Screens(navController: NavHostController) {

    val list: (Action) -> Unit = { action ->
        navController.navigate("list/${action.name}") {
            popUpTo(LIST_SCREEN) {
                inclusive = true
            }
        }
    }

    val task: (Int) -> Unit = { taskId ->
        navController.navigate("task/$taskId")
    }
}
