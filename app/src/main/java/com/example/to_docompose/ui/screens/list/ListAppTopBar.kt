package com.example.to_docompose.ui.screens.list

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ListAppTopBar(){
    DefaultListAppTopBar()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultListAppTopBar(){
    TopAppBar(
        title = {
            Text(text = "Tasks")
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.inversePrimary
        )
    )
}

@Preview
@Composable
fun DefaultListAppTopBarPreview(){
    DefaultListAppTopBar()
}