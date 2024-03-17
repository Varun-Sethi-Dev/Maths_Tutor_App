package com.example.maths_tutor_app.domain.authViewModel

import androidx.lifecycle.ViewModel
import com.example.maths_tutor_app.data.model.auth.AuthUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AuthViewModel: ViewModel(){

    private var _uiState = MutableStateFlow(AuthUiState())
    val uiState :StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun onUsernameEntered(name:String){
        _uiState.value = _uiState.value.copy(userName=name)
    }
    fun onPasswordEntered(data: String){
        _uiState.value = _uiState.value.copy(password = data)
    }
    fun onRePasswordEntered(data: String){
        _uiState.value = _uiState.value.copy(rePassword = data)
    }

    fun onEmailEntered(data: String) {
        _uiState.value = _uiState.value.copy(email = data)
    }
    fun reset(){
        _uiState.value = AuthUiState()
    }
    init {
        reset()
    }
}