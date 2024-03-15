package com.example.maths_tutor_app.presentation.ui.welcomeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.maths_tutor_app.R


@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    onGetStartedClicked: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .padding(top = 100.dp, bottom = 50.dp, start = 25.dp, end = 25.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                //.size(200.dp)
                .clip(RoundedCornerShape(12.dp))

                .background(color = Color.LightGray, shape = RoundedCornerShape(12.dp))
                .weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_foreground),
                contentDescription = "Maths Tutor App Logo",
                modifier = Modifier.fillMaxSize()
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Box(
            modifier = Modifier
                .weight(1f),
            contentAlignment = Alignment.TopStart
        ) {
            Column {
                Text(
                    text = "Maths Tutor App",
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontSize = 36.sp,
                    style = MaterialTheme.typography.headlineLarge
                )
                val loremText = LoremIpsum(20).values.first()
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = loremText,
                    modifier = Modifier
                        .fillMaxWidth(),
                    fontSize = 16.sp,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Justify
                )
            }
        }
        FloatingActionButton(
            onClick = { onGetStartedClicked() },
            modifier = Modifier
                .offset(y = (-50).dp)
                .align(Alignment.End)
                .wrapContentSize(),
            containerColor = Color.Black,
            contentColor = Color.White,
            shape = RoundedCornerShape(12.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(8.dp)
            ) {
                Text(text = "Get Started", fontSize = 24.sp)
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = R.drawable.arrowdown),
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
            }
        }
    }
}