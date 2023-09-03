package io.github.aniokrait.androidtoybox.ui.screen

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@Composable
fun MainScreen(
    navigate: () -> Unit
) {
    Button(onClick = navigate) {
        Text(text = "編集画面に遷移")
    }
}