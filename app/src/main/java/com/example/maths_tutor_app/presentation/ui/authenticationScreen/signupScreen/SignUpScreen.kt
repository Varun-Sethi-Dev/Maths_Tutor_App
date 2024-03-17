package com.example.maths_tutor_app.presentation.ui.authenticationScreen.signupScreen

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
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.maths_tutor_app.R
import com.example.maths_tutor_app.presentation.theme.Orange

@Preview(showBackground = true)
@Composable
fun SignUp(
    onTcClick: () -> Unit = {},
    onLoginClick: () -> Unit = {},
    onCaClicked: () -> Unit = {},
    username: String = "",
    password: String = "",
    rePassword: String = "",
    email: String = "",
    onUsernameChange: (String) -> Unit = {},
    onEmailChange: (String) -> Unit = {},
    onPasswordChange: (String) -> Unit = {},
    onRePasswordChange: (String) -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Image(
            painter = painterResource(id = R.drawable.maths_tutos_logo),
            contentDescription = "",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally),
            contentScale = ContentScale.Crop
        )
        Text(
            text = "Maths Tutor",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Start,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(32.dp))
        OutlinedTextField(value = username,
            onValueChange = { onUsernameChange(it) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            label = { Text(text = "Your Username") })
        OutlinedTextField(value = email,
            onValueChange = { onEmailChange(it) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            label = { Text(text = "Your Email ID") })
        var isPassVisible by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = password,
            onValueChange = { onPasswordChange(it) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            label = { Text(text = "Enter Password") },
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
        var isRePassVisible by remember { mutableStateOf(false) }
        OutlinedTextField(
            value = rePassword,
            onValueChange = { onRePasswordChange(it) },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            label = { Text(text = "Re-Enter Password") },
            trailingIcon = {
                Icon(painter = painterResource(id = if (isRePassVisible) R.drawable.view else R.drawable.hide),
                    contentDescription = "",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable {
                            isRePassVisible = !isRePassVisible
                        })
            },
            visualTransformation = if (isRePassVisible) VisualTransformation.None else PasswordVisualTransformation()
        )

        Button(
            onClick = { onCaClicked() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Orange, contentColor = Color.White
            )
        ) {
            Text(text = "+ Create an Account")
        }
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "By signing up you are agree to our  ", fontSize = 10.sp)
            Text(text = "Terms and condition",
                color = Color.Blue,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    onTcClick()
                })
        }
        Spacer(modifier = Modifier.height(14.dp))
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
            Text(text = "Already have an account?  ")
            Text(text = "Login",
                color = Color.Blue,
                fontWeight = FontWeight.Bold,
                textDecoration = TextDecoration.Underline,
                modifier = Modifier.clickable {
                    onLoginClick()
                })
        }
    }
}
