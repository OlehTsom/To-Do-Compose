package com.example.to_docompose.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_docompose.R
import com.example.to_docompose.ui.viewmodels.SharedVieModel
import com.example.to_docompose.utils.Action
import com.example.to_docompose.utils.SearchAppBarState
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedVieModel: SharedVieModel
) {

    val action by sharedVieModel.action

    LaunchedEffect(key1 = true){
        sharedVieModel.getAllTasks()
    }
    val allTasks by sharedVieModel.allTasks.collectAsState()

    val searchAppBarState: SearchAppBarState
            by sharedVieModel.searchAppBarState

    val searchTextState: String
            by sharedVieModel.searchTextState

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()


    val snackBarHostState = remember{SnackbarHostState()}

    DisplaySnackBar(
        snackBarHostState = snackBarHostState,
        handleDatabaseActions = { sharedVieModel.handleDatabaseActions(action) },
        taskTitle = sharedVieModel.title.value,
        action = action
    )

    Scaffold(modifier = Modifier
        .nestedScroll(scrollBehavior.nestedScrollConnection),
        snackbarHost = {
            SnackbarHost(hostState = snackBarHostState)
        },
        topBar = {
           ListAppTopBar(
               sharedVieModel = sharedVieModel,
               searchAppBarState = searchAppBarState,
               searchTextState = searchTextState,
               scrollBehavior = scrollBehavior
           )
        },

        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    ){innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 10.dp), // Змініть на вашу висоту AppBar
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


@Composable
fun DisplaySnackBar(
    snackBarHostState: SnackbarHostState,
    handleDatabaseActions: () -> Unit,
    taskTitle: String,
    action: Action
){

    handleDatabaseActions()

    val scope = rememberCoroutineScope()

    LaunchedEffect(key1 = action){
        if (action != Action.NO_ACTION){
            scope.launch {
                val snackBarResult = snackBarHostState
                    .showSnackbar(
                        message = "${action.name}: $taskTitle",
                        actionLabel = "Prima"
                    )
            }
        }
    }

}


// Не юзабильне через viewModel
@Preview
@Composable
fun PreviewListScreen() {
   // ListScreen(navigateToTaskScreen = {})
}