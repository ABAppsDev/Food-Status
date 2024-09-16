package org.example.food.status

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.WindowPlacement
import androidx.compose.ui.window.WindowState
import androidx.compose.ui.window.application

fun main() = application {
    val state = WindowState(
        placement = WindowPlacement.Fullscreen
    )
    Window(
        onCloseRequest = ::exitApplication,
        title = "Food Status",
        state = state,
        undecorated = true
    ) {
        App()
    }
}