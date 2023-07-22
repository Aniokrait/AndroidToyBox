package io.github.aniokrait.androidsandbox.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TransitSourceViewModel @Inject constructor(): BaseViewModel() {
    fun fetchSomeData(
        isLoadCompleted: MutableState<Boolean>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            //ここでIO処理
            delay(5000)
            //終わったら遷移
            withContext(Dispatchers.Main) {
                isLoadCompleted.value = true
            }
        }
    }
}