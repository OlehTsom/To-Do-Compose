package com.example.to_docompose.ui.screens.task

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.example.to_docompose.R
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.utils.Action

@Composable
fun TaskAppTopBar(
    navigateToListScreen: (Action) -> Unit
) {
    NewTaskAppBar(navigateToListScreen = navigateToListScreen)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewTaskAppBar(
    navigateToListScreen: (Action) -> Unit
) {
    TopAppBar(
        navigationIcon = {
            BackAction(onBackClicked = navigateToListScreen)
        },
        title = {
            Text(
                text = stringResource(R.string.add_task_text),
                color = MaterialTheme.colorScheme.surface,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        actions = { AddAction(onAddClicked = navigateToListScreen) },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.inversePrimary
        )
    )
}

@Composable
fun BackAction(
    onBackClicked: (Action) -> Unit
) {
    IconButton(onClick = { onBackClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back_arrow_text),
            tint = MaterialTheme.colorScheme.surface
        )
    }
}

@Composable
fun AddAction(
    onAddClicked: (Action) -> Unit
) {
    IconButton(onClick = { onAddClicked(Action.ADD) }) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(id = R.string.add_task_text),
            tint = MaterialTheme.colorScheme.surface
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExistingTaskAppBar(
    selectedTask: ToDoTask,
    navigateToListScreen: (Action) -> Unit
){
    TopAppBar(
        navigationIcon = {
            CloseAction(onCloseClicked = navigateToListScreen )
        },
        title = {
            Text(
                text = selectedTask.title,
                color = MaterialTheme.colorScheme.surface
            )
        },
        actions = {
            DeleteAction(onDeleteClicked = navigateToListScreen)
            UpdateAction(onUpdateClicked = navigateToListScreen)
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color(if (isSystemInDarkTheme())
                selectedTask.itemColorDarkTheme else selectedTask.itemColorLightTheme)
        )
    )
}

@Composable
fun CloseAction(
    onCloseClicked: (Action) -> Unit
){
    IconButton(onClick = { onCloseClicked(Action.NO_ACTION) }) {
        Icon(
            imageVector = Icons.Filled.Close,
            contentDescription = stringResource(R.string.close_task_text),
            tint = MaterialTheme.colorScheme.surface
        )
    }
}

@Composable
fun DeleteAction(
    onDeleteClicked: (Action) -> Unit
){
    IconButton(onClick = { onDeleteClicked(Action.DELETE) }) {
        Icon(
            imageVector = Icons.Filled.Delete,
            contentDescription = stringResource(R.string.delete_task_text),
            tint = MaterialTheme.colorScheme.surface
        )
    }
}

@Composable
fun UpdateAction(
    onUpdateClicked: (Action) -> Unit
){
    IconButton(onClick = { onUpdateClicked(Action.UPDATE)}) {
        Icon(
            imageVector = Icons.Filled.Check,
            contentDescription = stringResource(R.string.update_task_text),
            tint = MaterialTheme.colorScheme.surface
        )
    }
}

@Preview
@Composable
fun NewTaskAppBarPreview() {
    NewTaskAppBar(
        navigateToListScreen = {},
    )
}

@Preview
@Composable
fun ExistingTaskAppBarPreview(){
    ExistingTaskAppBar(
        selectedTask = ToDoTask(
            id = 0,
            "Pläne für Montag",
            "",
            "21212",
            Priority.LOW,
            Color.Black.toArgb(),
            Color.Black.toArgb()
        ),
        navigateToListScreen = {}
    )
}