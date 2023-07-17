package io.github.aniokrait.androidsandbox.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import io.github.aniokrait.androidsandbox.data.dataclass.IndicatorState

abstract class BaseViewModel: ViewModel() {
    companion object {
        private val _loadIndicatorState: MutableState<IndicatorState> = mutableStateOf(IndicatorState(false, ""))
        val loadIndicatorState: State<IndicatorState> = _loadIndicatorState
    }

    fun startLoad(text: String) {
        _loadIndicatorState.value = IndicatorState(true, text)
    }

    fun endLoad() {
        _loadIndicatorState.value = IndicatorState(false, "")
    }
}