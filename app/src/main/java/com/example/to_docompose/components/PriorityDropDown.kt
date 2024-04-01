package com.example.to_docompose.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material.ContentAlpha
import com.example.to_docompose.R
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.ui.theme.PRIORITY_DROP_DOWN_HIGH
import com.example.to_docompose.ui.theme.PRIORITY_INDICATOR_SIZE

@Composable
fun PriorityDropDown(
    priority: Priority,
    onPrioritySelected: (Priority) -> Unit
){

    var expended by remember {
        mutableStateOf(false)
    }

    val angle: Float by animateFloatAsState(
        targetValue = if (expended) 180f else 0f
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(PRIORITY_DROP_DOWN_HIGH)
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.onSecondaryContainer,
                shape = MaterialTheme.shapes.extraSmall

            )
            .clickable { expended = true },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Canvas(modifier = Modifier
            .weight(1f)
            .size(PRIORITY_INDICATOR_SIZE)
        ){
            drawCircle(
                color = priority.color
            )
        }
        Text(modifier = Modifier
                .weight(8f),
            text = priority.name,
            style = MaterialTheme.typography.bodyLarge,
            color = MaterialTheme.colorScheme.onSecondaryContainer
        )
        IconButton(modifier = Modifier
            .weight(1.5f)
            .rotate(angle)
            .alpha(ContentAlpha.medium),
            onClick = { expended = true }
        ) {
            Icon(
                imageVector = Icons.Filled.KeyboardArrowDown,
                contentDescription = stringResource(R.string.arrow_down_text)
            )
        }
        DropdownMenu(
            modifier = Modifier
                .background(color = MaterialTheme.colorScheme.background.copy(alpha = 0.8f))
                .fillMaxWidth(fraction = 0.94f),
            expanded = expended,
            onDismissRequest = { expended = false}
        ) {
            DropdownMenuItem(
                text = { PriorityItem(priority = Priority.LOW) },
                onClick = {
                    onPrioritySelected(Priority.LOW)
                    expended = false
                }
            )
            DropdownMenuItem(
                text = { PriorityItem(priority = Priority.MEDIUM) },
                onClick = {
                    onPrioritySelected(Priority.MEDIUM)
                    expended = false
                }
            )
            DropdownMenuItem(
                text = { PriorityItem(priority = Priority.HIGH) },
                onClick = {
                    onPrioritySelected(Priority.HIGH)
                    expended = false
                }
            )
        }
    }
}

@Preview
@Composable
fun PriorityDropDownPreview(){
    PriorityDropDown(
        priority = Priority.LOW,
        onPrioritySelected = {}
    )
}