package io.github.aniokrait.androidtoybox.ui.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp

@Composable
fun AnimatedScreen(
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        var showAnimation by remember{ mutableStateOf(false) }
        Button(onClick = { showAnimation = !showAnimation }) {
            Text(text = "フラグを切り替える")
        }

        //if文は不要！
        val density = LocalDensity.current
        AnimatedVisibility(
            visible = showAnimation,
            enter = slideInVertically {
                // Slide in from 40 dp from the top.
                with(density) { -40.dp.roundToPx() }
            },
        ) {
            Text("Hello",
                Modifier
                    .fillMaxWidth()
                    .height(200.dp))
        }
    }
}