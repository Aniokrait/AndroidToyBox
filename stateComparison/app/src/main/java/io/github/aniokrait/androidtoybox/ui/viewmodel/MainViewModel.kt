package io.github.aniokrait.androidtoybox.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlin.random.Random

class MainViewModel constructor(
    private val savedStateHandle: SavedStateHandle
): ViewModel() {
    //StateFlowの宣言
//    private val _flowCount = MutableStateFlow(0)
//    val flowCount = _flowCount.asStateFlow()
    //StateFlowの宣言（savedStateHandleを使う場合）
    val flowCount = savedStateHandle.getStateFlow("count", 0)

    //Compose Stateの宣言
    var composeCount by mutableStateOf(
//        0
        //savedStateHandleを使う場合
    savedStateHandle.get<Int>("count") ?: 0
    )
        private set

    fun generateNewComposeCount() {
        val newCount = Random.nextInt(1000)
        //savedStateHandleを使う場合
        savedStateHandle["count"] = newCount
        //savedStateHandleを使う場合もCompose Stateへの代入は必要
        composeCount = newCount
    }

    fun generateNewFlowCount() {
        val newCount = Random.nextInt(1000)
//        _flowCount.value = newCount
        //savedStateHandleを使う場合
        savedStateHandle["count"] = newCount
    }
}