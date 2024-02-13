package com.example.to_docompose.ui.screens.list

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.R
import com.example.to_docompose.ui.viewmodels.SharedVieModel
import com.example.to_docompose.utils.SearchAppBarState


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ListScreen(
    navigateToTaskScreen: (taskId: Int) -> Unit,
    sharedVieModel: SharedVieModel
) {
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
        content = {
            ListContent()
        },
        floatingActionButton = {
            ListFab(onFabClicked = navigateToTaskScreen)
        }
    )
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