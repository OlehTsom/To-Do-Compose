package com.example.to_docompose.ui.screens.task

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.ui.viewmodels.SharedVieModel
import com.example.to_docompose.utils.Action
import com.example.to_docompose.utils.RequestState

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    sharedVieModel: SharedVieModel,
    selectedTask: ToDoTask?,
    navigateToListScreen: (Action) -> Unit
) {

    val title: String by sharedVieModel.title
    val description: String by sharedVieModel.description
    val priority: Priority by sharedVieModel.priority

    val context = LocalContext.current

    Scaffold(
        topBar = {
            TaskAppTopBar(
                selectedTask = selectedTask,
                navigateToListScreen = { action ->
                    if (action == Action.NO_ACTION) {
                        navigateToListScreen(action)
                    } else {
                        if (sharedVieModel.validateFields()) {
                            navigateToListScreen(action)
                        } else {
                            displayToast(context)
                        }
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = androidx.compose.ui.Modifier
                .padding(paddingValues)
        ) {
            TaskContent(
                title = title,
                onTitleChanged = { title ->
                    sharedVieModel.updateTitle(title)
                },
                description = description,
                onDescriptionChanged = { description ->
                    sharedVieModel.description.value = description
                },
                priority = priority,
                onPrioritySelected = { priority ->
                    sharedVieModel.priority.value = priority
                }
            )
        }
    }
}

fun displayToast(context: Context){
    Toast.makeText(
            context,
            "Felder sind leer",
            Toast.LENGTH_SHORT
        ).show()
}