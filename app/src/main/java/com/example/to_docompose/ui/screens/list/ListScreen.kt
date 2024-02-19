package com.example.to_docompose.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_docompose.R
import com.example.to_docompose.ui.viewmodels.SharedVieModel
import com.example.to_docompose.utils.SearchAppBarState


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedVieModel: SharedVieModel
) {
    LaunchedEffect(key1 = true){
        sharedVieModel.getAllTasks()
    }
    val allTasks by sharedVieModel.allTasks.collectAsState()

    val searchAppBarState: SearchAppBarState
            by sharedVieModel.searchAppBarState

    val searchTextState: String
            by sharedVieModel.searchTextState

    Scaffold(
        topBar = {
           ListAppTopBar(
               sharedVieModel = sharedVieModel,
               searchAppBarState = searchAppBarState,
               searchTextState = searchTextState
           )
        },

        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    ){innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(10.dp), // Змініть на вашу висоту AppBar
        ) {
            ListContent(
                toDoTasks = allTasks,
                navigateToTaskScreen = navigateToTaskScreen
            )
        }
    }
}

@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
) {
    //TODO("Замінити на Extended FAB")
    FloatingActionButton(
        onClick = {
            onFabClicked(-1)
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(R.string.add_button)
        )
    }
}


// Не юзабильне через viewModel
@Preview
@Composable
fun PreviewListScreen() {
   // ListScreen(navigateToTaskScreen = {})
}