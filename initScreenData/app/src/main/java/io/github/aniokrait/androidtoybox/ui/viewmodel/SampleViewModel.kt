package io.github.aniokrait.androidtoybox.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@HiltViewModel
class SampleViewModel: ViewModel() {
    private val _state: MutableState<String> = mutableStateOf("")
    val state: State<String> = _state
    fun superLongAsyncMethod() {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                delay(10000000000)
            }
            _state.value = "取得終了"
        }
    }
}