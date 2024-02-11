package com.example.to_docompose.ui.screens.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import com.example.to_docompose.R
import com.example.to_docompose.components.PriorityItem
import com.example.to_docompose.data.models.Priority
import com.example.to_docompose.ui.theme.SEARCH_TOP_BAR_HIGH
import com.example.to_docompose.ui.viewmodels.SharedVieModel
import com.example.to_docompose.utils.SearchAppBarState
import com.example.to_docompose.utils.TrailingIconState

@Composable
fun ListAppTopBar(
    sharedVieModel: SharedVieModel,
    searchAppBarState: SearchAppBarState,
    searchTextState: String
) {

    when(searchAppBarState){
        SearchAppBarState.CLOSED ->{
            DefaultListAppTopBar(
                onSearchClicked = {
                    sharedVieModel.searchAppBarState.value =
                        SearchAppBarState.OPENED
                },
                onSortClicked = {},
                onDeleteClicked = {}
            )
        }
        else -> {
            SearchAppBar(
                text = searchTextState ,
                onTextChange = {newSearchQuery ->
                    sharedVieModel.searchTextState.value =
                        newSearchQuery
                },
                onSearchClicked = {},
                onCloseClicked = {
                    sharedVieModel.searchAppBarState.value =
                        SearchAppBarState.CLOSED
                    sharedVieModel.searchTextState.value = ""
                }
            )
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppTopBar(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    TopAppBar(
        title = {
            Text(text = stringResource(R.string.tasks))
        },
        actions = {
            ListAppBarAction(
                onSearchClicked = onSearchClicked,
                onSortClicked = onSortClicked,
                onDeleteClicked = onDeleteClicked
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.inversePrimary
        )
    )
}

@Composable
fun ListAppBarAction(
    onSearchClicked: () -> Unit,
    onSortClicked: (Priority) -> Unit,
    onDeleteClicked: () -> Unit
) {
    SearchAction(onSearchClicked = onSearchClicked)
    SortAction(onSortClicked = onSortClicked)
    DeleteAllItems(onDeleteClicked = onDeleteClicked)
}

@Composable
fun SearchAction(
    onSearchClicked: () -> Unit
) {
    IconButton(
        onClick = {
            onSearchClicked()
        }
    ) {
        Icon(
            imageVector = Icons.Filled.Search,
            contentDescription = stringResource(R.string.search_action),
            tint = MaterialTheme.colorScheme.surface
        )
    }
}

@Composable
fun SortAction(
    onSortClicked: (Priority) -> Unit
) {

    var expended by remember { mutableStateOf(false) }

    IconButton(onClick = {
        expended = true
    }) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = stringResource(R.string.sort_tasks),
            tint = MaterialTheme.colorScheme.surface
        )
        DropdownMenu(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseOnSurface),
            expanded = expended,
            onDismissRequest = { expended = false }
        ) {
            DropdownMenuItem(
                text = {
                    PriorityItem(priority = Priority.LOW)
                },
                onClick = {
                    onSortClicked(Priority.LOW)
                    expended = false
                }
            )
            DropdownMenuItem(
                text = {
                    PriorityItem(priority = Priority.MEDIUM)
                },
                onClick = {
                    onSortClicked(Priority.MEDIUM)
                    expended = false
                }
            )
            DropdownMenuItem(
                text = {
                    PriorityItem(priority = Priority.HIGH)
                },
                onClick = {
                    onSortClicked(Priority.HIGH)
                    expended = false
                }
            )
            DropdownMenuItem(
                text = {
                    PriorityItem(priority = Priority.NONE)
                },
                onClick = {
                    onSortClicked(Priority.NONE)
                    expended = false
                }
            )
        }
    }
}

@Composable
fun DeleteAllItems(
    onDeleteClicked: () -> Unit
) {
    var expended by remember { mutableStateOf(false) }

    IconButton(onClick = {
        expended = true
    }) {
        Icon(
            imageVector = Icons.Filled.MoreVert,
            contentDescription = stringResource(R.string.sort_tasks),
            tint = MaterialTheme.colorScheme.surface
        )
        DropdownMenu(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.inverseOnSurface),
            expanded = expended,
            onDismissRequest = { expended = false }
        ) {
            DropdownMenuItem(
                text = {
                    Text(
                        text = stringResource(R.string.delete_tasks),
                        color = MaterialTheme.colorScheme.onSecondaryContainer
                    )
                },
                onClick = {
                    expended = false
                    onDeleteClicked()
                })
        }
    }
}

@Composable
fun SearchAppBar(
    text: String,
    onTextChange: (text: String) -> Unit,
    onSearchClicked: (searchQuery: String) -> Unit,
    onCloseClicked: () -> Unit
){

    var trailingIconState by remember {
        mutableStateOf(TrailingIconState.READY_TO_DELETE)
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(SEARCH_TOP_BAR_HIGH),
        shadowElevation = 4.dp,//TODO("Розубратись з дефолтною elevation")
        color = MaterialTheme.colorScheme.inversePrimary
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth(),
            value = text,
            onValueChange = {newText ->
                onTextChange(newText)
            },
            placeholder =  {
                Text(
                    modifier = Modifier
                        .alpha(0.5f),
                    text = stringResource(R.string.search),
                    color = Color.White
                )
            },
            textStyle = MaterialTheme.typography.bodyMedium,
            singleLine = true,
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        modifier = Modifier
                            .alpha(0.38f),
                        imageVector = Icons.Filled.Search,
                        contentDescription = stringResource(R.string.search_icon),
                        tint = MaterialTheme.colorScheme.surface
                    )
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    when(trailingIconState){
                        TrailingIconState.READY_TO_DELETE ->{
                            if (text.isEmpty()){
                                onCloseClicked()
                            }else{
                                onTextChange("")
                                trailingIconState = TrailingIconState.READY_TO_CLOSE
                            }
                        }
                        TrailingIconState.READY_TO_CLOSE ->{
                            if (text.isNotEmpty()){
                                onTextChange("")
                            }else{
                                onCloseClicked()
                                trailingIconState = TrailingIconState.READY_TO_DELETE
                            }
                        }
                    }
                }) {
                    Icon(
                        modifier = Modifier
                            .alpha(0.78f),
                        imageVector = Icons.Filled.Close,
                        contentDescription = stringResource(R.string.close_icon),
                        tint = MaterialTheme.colorScheme.surface
                    )
                }
            },
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                cursorColor = MaterialTheme.colorScheme.surface.copy(alpha = 0.8f),
                focusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Search
            ),
            keyboardActions = KeyboardActions(
                onSearch = {
                    onSearchClicked(text)
                }
            )
        )
    }

}

@Preview
@Composable
fun DefaultListAppTopBarPreview() {
    DefaultListAppTopBar(
        onSearchClicked = {},
        onSortClicked = {},
        onDeleteClicked = {}
    )
}

@Preview
@Composable
fun SearchAppBArPreview(){
    SearchAppBar(
        text = "" ,
        onTextChange = {},
        onSearchClicked = { },
        onCloseClicked = {}
    )
}