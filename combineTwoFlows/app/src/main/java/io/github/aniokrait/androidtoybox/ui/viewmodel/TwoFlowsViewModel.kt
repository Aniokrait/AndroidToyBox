package io.github.aniokrait.androidtoybox.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import io.github.aniokrait.androidtoybox.data.dataclass.UserInfo
import io.github.aniokrait.androidtoybox.data.repository.UserInfoRepository
import io.github.aniokrait.androidtoybox.ui.state.TwoFlowsUiState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TwoFlowsViewModel @Inject constructor(
    userInfoRepository: UserInfoRepository
): ViewModel() {
    //ユーザが入力した値を保持するMutableStateFlow
    private val userInputState = MutableStateFlow(TwoFlowsUiState(name = "", email = ""))
    //サーバから取得する用のFlow
    private lateinit var fetchedState: Flow<UserInfo>
    //ユーザがテキストフィールドを更新したか判定するためのフラグ
    private var isUserOverridden = false

    lateinit var uiState: StateFlow<TwoFlowsUiState>

    init {
        viewModelScope.launch {
            fetchedState = userInfoRepository.getUserInfo()
            uiState = combine(userInputState, fetchedState) { input, fetched ->
                if(isUserOverridden) {
                    //ユーザが何かを入力した場合は、以降ユーザが入力した値を優先する
                    input
                } else {
                    //inputフィールドに取得した情報を反映する
                    val converted = toUiStateFrom(fetched)
                    userInputState.value = converted
                    converted
                }
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = TwoFlowsUiState(name = "", email = "")
            )
        }
    }

    private fun toUiStateFrom(fetched: UserInfo): TwoFlowsUiState {
        return TwoFlowsUiState(
            name = fetched.name,
            email = fetched.email,
        )
    }

    fun updateName(newName: String) {
        isUserOverridden = true
        userInputState.value = userInputState.value.copy(name = newName)
    }

    fun updateEmail(newEmail: String) {
        isUserOverridden = true
        userInputState.value = userInputState.value.copy(email = newEmail)
    }
}
