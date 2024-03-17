package com.example.maths_tutor_app.presentation.ui.authenticationScreen.loginScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.maths_tutor_app.R
import com.example.maths_tutor_app.presentation.theme.Orange

@Preview(showBackground = true)
@Composable
fun LogIn(onLoginClicked: () -> Unit={},
          onSignUpClicked: () -> Unit={},
          username:String="",
          password:String="",
          onUserNameChange:(String)->Unit={},
          onPasswordChange:(String)->Unit={}
          ) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.maths_tutos_logo),
            contentDescription = "",
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )

        Column(
            Modifier
                .padding(12.dp)
                .weight(4f)
        ) {
            Text(
                text = "Maths Tutor",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier.padding(top = 4.dp, bottom = 4.dp),
                textAlign = TextAlign.Center
            )

            OutlinedTextField(
                value = username,
                onValueChange = {onUserNameChange(it) },
                label = { Text("Username") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp)
            )
            var isPassVisible by remember { mutableStateOf(false) }
            OutlinedTextField(
                value = password,
                onValueChange = {onPasswordChange(it)},
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                label = { Text(text = "Password") },
                trailingIcon = {
                    Icon(painter = painterResource(id = if (isPassVisible) R.drawable.view else R.drawable.hide),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .clickable {
                                isPassVisible = !isPassVisible
                            })
                },
                visualTransformation = if (isPassVisible) VisualTransformation.None else PasswordVisualTransformation()
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    onLoginClicked()
                    // Handle login logic here (e.g., validation, authentication)
                    // Assuming successful login navigates to "home"
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Orange)
            ) {
                Text("Login")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier.weight(1f)
                )
                Text(text = "Or", modifier = Modifier.padding(horizontal = 4.dp))
                Divider(
                    modifier = Modifier.weight(1f)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Don't have an account? ")
                TextButton(
                    onClick = {
                        onSignUpClicked()
                    }, colors = ButtonDefaults.textButtonColors(contentColor = Color.Blue)
                ) { // Navigate to signup screen
                    Text(
                        text = "Sign Up", fontWeight = FontWeight.Bold, fontSize = 16.sp
                    )
                }
            }
        }

    }
}