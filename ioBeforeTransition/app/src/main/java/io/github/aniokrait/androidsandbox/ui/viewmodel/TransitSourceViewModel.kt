package io.github.aniokrait.androidsandbox.ui.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import javax.inject.Inject

@HiltViewModel
class TransitSourceViewModel @Inject constructor(): BaseViewModel() {
    fun fetchSomeData(
        isLoadCompleted: MutableState<Boolean>
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            //ここでIO処理
            try {
                delay(5000)
            } catch (e: Exception) {
                // throwするなりResultをreturnするなり適切にエラーハンドリングして
                // 処理がここで終わるようにしてください
            }

            //IOが正常終了したら遷移
            withContext(Dispatchers.Main) {
                //navController.navigateを実行するのではなく、MutableStateを更新する
                isLoadCompleted.value = true
            }
        }
    }
}