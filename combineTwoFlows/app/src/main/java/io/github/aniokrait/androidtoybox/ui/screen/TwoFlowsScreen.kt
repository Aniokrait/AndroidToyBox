package io.github.aniokrait.androidtoybox.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import io.github.aniokrait.androidtoybox.ui.viewmodel.TwoFlowsViewModel

@Composable
fun TwoFlowsScreen(
    viewModel: TwoFlowsViewModel
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        InputField(
            label = "name",
            fieldValue = uiState.name,
            updateValue = { updatedValue -> viewModel.updateName(updatedValue) }
        )
        InputField(
            label = "email",
            fieldValue = uiState.email,
            updateValue = { updatedValue -> viewModel.updateEmail(updatedValue) }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun InputField(
    label: String,
    fieldValue: String,
    updateValue: (String) -> Unit
) {
    Row(
        modifier = Modifier.padding(start = 12.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(end = 12.dp),
            text = label
        )
        TextField(
            value = fieldValue,
            onValueChange = { updateValue(it) }
        )
    }
}