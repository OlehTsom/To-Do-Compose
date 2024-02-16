package com.example.to_docompose.ui.screens.list


import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.data.models.ToDoTask
import com.example.to_docompose.ui.theme.DESCRIPTION_TEXT_END_PADDING
import com.example.to_docompose.ui.theme.LARGE_PADDING
import com.example.to_docompose.ui.theme.MEDIUM_PADDING
import com.example.to_docompose.ui.theme.PRIORITY_INDICATOR_SIZE
import com.example.to_docompose.ui.theme.TASK_ITEM_ELEVATION
import com.example.to_docompose.ui.theme.getRandomsColorForTheme

@Composable
fun ListContent(
    toDoTasks: List<ToDoTask>,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    if (toDoTasks.isEmpty()){
        EmptyContent()
    }else{
        DisplayTasks(
            toDoTasks = toDoTasks,
            navigateToTaskScreen = navigateToTaskScreen
        )
    }
}

@Composable
fun DisplayTasks(
    toDoTasks: List<ToDoTask>,
    navigateToTaskScreen: (taskId: Int) -> Unit
){
    LazyColumn() {
        items(
            items = toDoTasks,
            key = { task ->
                task.id
            }) {task ->
            TaskItem(
                toDoTask = task,
                navigateToTaskScreen = navigateToTaskScreen
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@Composable
fun TaskItem(
    toDoTask: ToDoTask,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {


    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = if (isSystemInDarkTheme())
            Color(toDoTask.itemColorDarkTheme) else Color(toDoTask.itemColorLightTheme),
        shape = ShapeDefaults.Small,
        shadowElevation = TASK_ITEM_ELEVATION,
        onClick = {
            navigateToTaskScreen(toDoTask.id)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(all = MEDIUM_PADDING)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    text = toDoTask.title,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    style = MaterialTheme.typography.titleLarge
                )
                Box(
                    modifier = Modifier
                        .weight(1f),
                    contentAlignment = Alignment.TopEnd
                ) {
                    Canvas(
                        modifier = Modifier
                            .size(PRIORITY_INDICATOR_SIZE),
                        onDraw = {
                            drawCircle(
                                color = toDoTask.priority.color
                            )
                        }
                    )
                }
            }
            Spacer(modifier = Modifier.height(MEDIUM_PADDING))
            Box(
                modifier = Modifier
                    .padding(end = DESCRIPTION_TEXT_END_PADDING)
                    .fillMaxWidth()
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = toDoTask.description,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                        .copy(alpha = 0.85f),
                    maxLines = 2,
                    style = MaterialTheme.typography.bodyLarge,
                    overflow = TextOverflow.Ellipsis
                )
            }
            Spacer(modifier = Modifier.height(LARGE_PADDING))
            Box(
                modifier = Modifier
                    .fillMaxWidth(),
                contentAlignment = Alignment.CenterEnd
            ) {
                Text(
                    text = toDoTask.dateAdded,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                        .copy(alpha = 0.85f),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

        }
    }

}

@Preview
@Composable
fun TaskItemPreview() {
    TaskItem(
        toDoTask = ToDoTask(
            1,
            "Pläne für Montag",
            "Am 8:00 gehe ich einzukaufen, später treffe ich mich mit dem Freund jeh jhwke jhkjwhe  hwkej kwjhekw khwkejK  knwe",
            "13.02.2024",
            Priority.LOW,
            getRandomsColorForTheme().keys.first(),
            getRandomsColorForTheme().values.first()
        ),
        navigateToTaskScreen = {}
    )
}