package io.github.aniokrait.androidtoybox.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun TransitSourceScreen(
    showIndicator: MutableState<Boolean>,
    transit: () -> Unit
) {

    Column {
        Button(onClick = {
            showIndicator.value = true
            transit()
        }) {
            Text("遷移する")
        }
    }
    if(showIndicator.value) {
        Box(modifier = Modifier
            .fillMaxSize()
            .background(color = Color.Black.copy(alpha = 0.3f))
            ,
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }
}
