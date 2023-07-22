package io.github.aniokrait.androidsandbox.ui.viewmodel

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class TransitTargetViewModel @Inject constructor(): BaseViewModel() {
    fun loadScreenInfo() = viewModelScope.launch {
//        withContext(Dispatchers.Main) {
//            startLoad("ロード開始")
//        }
//        withContext(Dispatchers.IO) {
//            delay(5000)
//        }
//        withContext(Dispatchers.Main) {
//            endLoad()
//        }

        startLoad("ロード開始") {
            withContext(Dispatchers.IO) {
                delay(5000)
            }
        }
    }
}