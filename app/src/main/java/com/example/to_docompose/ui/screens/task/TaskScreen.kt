package com.example.to_docompose.ui.screens.task

import android.annotation.SuppressLint
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import com.example.to_docompose.utils.Action

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun TaskScreen(
    navigateToListScreen: (Action) -> Unit
){
    Scaffold(
        topBar = {
            TaskAppTopBar(navigateToListScreen = navigateToListScreen)
        }
    ){paddingValues ->

    }
}