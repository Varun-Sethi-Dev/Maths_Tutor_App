package com.example.maths_tutor_app.domain.authViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.maths_tutor_app.data.model.auth.AuthUiState
import com.example.maths_tutor_app.data.repository.UserRepository
import com.example.maths_tutor_app.data.utils.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

class AuthViewModel(
    private val userRepository: UserRepository
) : ViewModel() {
    private val scope = viewModelScope
    private var _uiState = MutableStateFlow(AuthUiState())
    val uiState: StateFlow<AuthUiState> = _uiState.asStateFlow()

    fun onUsernameEntered(name: String) {
        _uiState.value = _uiState.value.copy(userName = name)
    }

    fun onPasswordEntered(data: String) {
        _uiState.value = _uiState.value.copy(password = data)
    }

    fun onRePasswordEntered(data: String) {
        _uiState.value = _uiState.value.copy(rePassword = data)
    }

    fun onEmailEntered(data: String) {
        _uiState.value = _uiState.value.copy(email = data)
    }

    fun reset() {
        _uiState.value = AuthUiState()
    }

    fun onCaClickAddUser(): Boolean {
        val user: User = authUiStateToUser(uiState.value)
        return try {
            scope.launch(context = Dispatchers.IO) {
                userRepository.addUser(user)
            }
            true
        } catch (e: Exception) {
            false
        }
    }

    fun onLoginClickCheckUser(): Boolean {
        var userReceived: User? = null
        return try {
            scope.launch(context = Dispatchers.IO) {
                userReceived = userRepository.readLoginData(
                    username = uiState.value.userName,
                    password = uiState.value.password
                ).firstOrNull()
            }
            userReceived != null
        } catch (e: Exception) {
            false
        }
    }

    private fun authUiStateToUser(authUiState: AuthUiState): User = User(
        email = authUiState.email,
        username = authUiState.userName,
        password = authUiState.password
    )

    init {
        reset()
    }
}