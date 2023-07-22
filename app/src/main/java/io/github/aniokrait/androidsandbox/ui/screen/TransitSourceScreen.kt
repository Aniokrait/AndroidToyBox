package io.github.aniokrait.androidsandbox.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavBackStackEntry
import kotlin.reflect.KProperty

@Composable
fun TransitSourceScreen(
    transit: () -> Unit
) {
    var showIndicator by remember { mutableStateOf(false) }

    Column {
        Button(onClick = {
            showIndicator = true
            transit()
        }) {
            Text("遷移する")
        }
    }
    if(showIndicator) {
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
