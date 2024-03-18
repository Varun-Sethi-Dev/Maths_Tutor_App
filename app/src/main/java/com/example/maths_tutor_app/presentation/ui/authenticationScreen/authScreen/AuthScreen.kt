package com.example.maths_tutor_app.presentation.ui.authenticationScreen.authScreen

import android.widget.Toast
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.maths_tutor_app.di.AppViewModelProvider
import com.example.maths_tutor_app.domain.authViewModel.AuthViewModel
import com.example.maths_tutor_app.presentation.ui.authenticationScreen.loginScreen.LogIn
import com.example.maths_tutor_app.presentation.ui.authenticationScreen.signupScreen.SignUp

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AuthScreen(
    onSignUpClicked: () -> Unit = {},
    onLoginClicked: () -> Unit = {},
    onTcClick: () -> Unit = {},
    onCaClicked: () -> Unit = {},
    viewModel: AuthViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    var isComposed by remember { mutableStateOf(false) }
    LaunchedEffect(true) {
        isComposed = true
    }

    val colorState by animateColorAsState(
        targetValue = if (!isComposed) Color.White else Color.LightGray,
        label = "",
        animationSpec = tween(500, 150, LinearEasing)
    )
    var signUpState by remember { mutableStateOf(false) }
    val verticalPadding = animateDpAsState(
        targetValue = if (!signUpState) 20.dp else 0.dp,
        label = ""

    )
    val uiState by viewModel.uiState.collectAsState()
    val context = LocalContext.current
    Column(
        Modifier
            .fillMaxSize()
            .background(colorState)
    ) {
        Spacer(
            modifier = Modifier.weight(1f)
        )

        Box(
            modifier = Modifier
                .weight(6f)
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
                .shadow(4.dp, RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp))
                .background(
                    Color.White, RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
                )
                .padding(horizontal = 20.dp, vertical = verticalPadding.value)
        ) {
            if (!signUpState) {
                LogIn(onLoginClicked = {
                    if (viewModel.onLoginClickCheckUser()) {
                        onLoginClicked()
                        Toast.makeText(context, "Login Success", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(context, "No User Found", Toast.LENGTH_SHORT).show()
                    }
                },
                    onSignUpClicked = {
                        viewModel.reset()
                        signUpState = !signUpState
                    },
                    username = uiState.userName,
                    password = uiState.password,
                    onUserNameChange = {
                        viewModel.onUsernameEntered(it)
                    },
                    onPasswordChange = {
                        viewModel.onPasswordEntered(it)
                    }
                )
            } else {
                SignUp(
                    onTcClick = onTcClick,
                    onLoginClick = {
                        viewModel.reset()
                        signUpState = !signUpState
                    },
                    onCaClicked = {
                        if (viewModel.onCaClickAddUser()) {
                            onCaClicked()
                            Toast.makeText(
                                context,
                                "Welcome ${uiState.userName}",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                context,
                                "Creating Account Failed",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    },
                    username = uiState.userName,
                    password = uiState.password,
                    rePassword = uiState.rePassword,
                    email = uiState.email,
                    onUsernameChange = { viewModel.onUsernameEntered(it) },
                    onPasswordChange = { viewModel.onPasswordEntered(it) },
                    onRePasswordChange = { viewModel.onRePasswordEntered(it) },
                    onEmailChange = { viewModel.onEmailEntered(it) },
                )
            }

        }
    }
}