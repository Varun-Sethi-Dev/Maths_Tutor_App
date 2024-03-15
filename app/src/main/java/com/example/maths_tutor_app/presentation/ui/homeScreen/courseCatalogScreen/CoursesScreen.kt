package com.example.maths_tutor_app.presentation.ui.homeScreen.courseCatalogScreen

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontSynthesis
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.maths_tutor_app.R
import com.example.maths_tutor_app.domain.navigation.AppScreens
import com.example.maths_tutor_app.presentation.theme.Orange
import com.example.maths_tutor_app.presentation.ui.homeScreen.userProfleScreen.ProfileScreen

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
) {
    Scaffold(modifier = Modifier
        .fillMaxSize(), topBar = { MyTopAppBar() },
        bottomBar = {

        }) { internalPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(internalPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = AppScreens.HomeLessonsCatalogScreen.route,
                modifier = Modifier.weight(1f)
            ) {
                composable(route = AppScreens.HomeLessonsCatalogScreen.route, enterTransition = {
                    slideInVertically(
                        initialOffsetY = { it }, // Start from bottom of screen
                        animationSpec = tween(300, 0, LinearEasing)
                    ) + fadeIn(tween(300, 0, LinearEasing), 0f)
                }, exitTransition = {
                    slideOutVertically(
                        targetOffsetY = { it }, animationSpec = tween(300, 0, LinearEasing)
                    ) + fadeOut(tween(300, 0, LinearEasing), 0f)

                }) {
                    CoursesScreen(Modifier.weight(1f))
                }
                composable(route = AppScreens.HomeMyCourseCatalogScreen.route, enterTransition = {
                    slideInVertically(
                        initialOffsetY = { it }, // Start from bottom of screen
                        animationSpec = tween(300, 0, LinearEasing)
                    ) + fadeIn(tween(300, 0, LinearEasing), 0f)
                }, exitTransition = {
                    slideOutVertically(
                        targetOffsetY = { it }, animationSpec = tween(300, 0, LinearEasing)
                    ) + fadeOut(tween(300, 0, LinearEasing), 0f)

                }) {
                    OnGoingCoursesScreen()
                }
                composable(route = AppScreens.HomeMyProfileScreen.route, enterTransition = {
                    slideInVertically(
                        initialOffsetY = { it }, // Start from bottom of screen
                        animationSpec = tween(300, 0, LinearEasing)
                    ) + fadeIn(tween(300, 0, LinearEasing), 0f)
                }, exitTransition = {
                    slideOutVertically(
                        targetOffsetY = { it }, animationSpec = tween(300, 0, LinearEasing)
                    ) + fadeOut(tween(300, 0, LinearEasing), 0f)

                }) {
                    ProfileScreen()
                }
            }
            val navigationItemContentList = listOf(
                NavigationItemContent(
                    homeTabType = HomeTabType.Home,
                    icon = Icons.Default.Home,
                    text = "Home"
                ), NavigationItemContent(
                    homeTabType = HomeTabType.MyCourses,
                    icon = Icons.Default.AccountBox,
                    text = "My Courses"
                ), NavigationItemContent(
                    homeTabType = HomeTabType.Profile,
                    icon = Icons.Default.Person,
                    text = "My Profile"
                )
            )
            var currTabState by remember {
                mutableStateOf(HomeTabType.Home)
            }
            Spacer(modifier = Modifier.weight(0.05f))
            BottomNavigationBar(
                currentTab = currTabState,
                onTabPressed = {
                    currTabState = it
                    when (it) {
                        HomeTabType.Home -> {
                            navController.navigate(route = AppScreens.HomeLessonsCatalogScreen.route)
                        }

                        HomeTabType.MyCourses -> {
                            navController.navigate(route = AppScreens.HomeMyCourseCatalogScreen.route)

                        }

                        HomeTabType.Profile -> {
                            navController.navigate(route = AppScreens.HomeMyProfileScreen.route)

                        }
                    }
                },
                navigationItemContentList = navigationItemContentList,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .height(100.dp)
            )


        }


    }

}

@Composable
fun CoursesScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = AnnotatedString(
                "Let's Learn \n", spanStyle = SpanStyle(
                    fontSize = 32.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal,
                    fontStyle = FontStyle.Normal,
                    fontSynthesis = FontSynthesis.All,
                    fontFamily = FontFamily.Monospace
                )
            ) + AnnotatedString(
                "Something New", spanStyle = SpanStyle(
                    fontSize = 32.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Normal,
                    fontSynthesis = FontSynthesis.All,
                    fontFamily = FontFamily.Monospace
                )
            ),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth(),
            minLines = 2,
            lineHeight = 44.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Lessons :-",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp),
            color = Orange,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.weight(1f))
        CatalogOfLessons()
        Spacer(modifier = Modifier.weight(1f))
        Text(
            text = "Practise :-",
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp),
            color = Orange,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.weight(1f))

        CatalogForPractise()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar() {
    TopAppBar(title = { }, navigationIcon = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Default.Menu,
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }
    }, actions = {
        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Rounded.Search,
                contentDescription = null,
                modifier = Modifier
                    .background(Color.DarkGray, CircleShape)
                    .padding(4.dp),
                tint = Color.White
            )
        }

        IconButton(onClick = { /*TODO*/ }) {
            Icon(
                imageVector = Icons.Rounded.Notifications,
                contentDescription = null,
                modifier = Modifier
                    .background(Color.DarkGray, CircleShape)
                    .padding(4.dp),
                tint = Color.White
            )
        }
    })
}

@Preview
@Composable
fun CatalogOfLessons() {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(4) {
                CatalogItem(
                    color = Color.LightGray,
                    painter = painterResource(id = R.drawable.trigonometry),
                    textValue = "Trigonometry $it",
                    modifier = Modifier
                )
            }
        },
        modifier = Modifier.padding(horizontal = 4.dp)
    )
}

@Composable
fun CatalogItem(
    modifier: Modifier = Modifier, color: Color, painter: Painter, textValue: String
) {

    Box(
        modifier = modifier
            .padding(4.dp)
            .aspectRatio(1.5f)
            .clip(RoundedCornerShape(8.dp))
            .background(color)
            .padding(2.dp), contentAlignment = Alignment.Center
    ) {
        Column(modifier = Modifier) {
            Image(
                painter = painter, contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .size(90.dp)
                    .padding(4.dp),
                contentScale = ContentScale.Crop,
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = textValue,
                modifier = Modifier
                    .wrapContentWidth()
                    .background(Color.White, RoundedCornerShape(4.dp))
                    .padding(2.dp)
            )

        }

    }
}

@Composable
fun CatalogForPractise(modifier: Modifier = Modifier) {
    Row(modifier = modifier.fillMaxWidth()) {
        CatalogItem(
            color = Color.LightGray,
            painter = painterResource(id = R.drawable.trigonometry),
            textValue = "Practise Quiz",
            modifier = Modifier
                .weight(1f)
                .padding(4.dp)
        )
        CatalogItem(
            color = Color.LightGray,
            painter = painterResource(id = R.drawable.trigonometry),
            textValue = "Prepare your own Quiz",
            modifier = Modifier
                .weight(1f)
            .padding(4.dp)
        )
    }
}

enum class HomeTabType {
    Home, MyCourses, Profile
}

private data class NavigationItemContent(
    val homeTabType: HomeTabType, val icon: ImageVector, val text: String
)

@OptIn(ExperimentalLayoutApi::class)
@Composable
private fun BottomNavigationBar(
    currentTab: HomeTabType,
    onTabPressed: ((HomeTabType) -> Unit),
    navigationItemContentList: List<NavigationItemContent>,
    modifier: Modifier = Modifier
) {
    NavigationBar(
        modifier = modifier,
        windowInsets = WindowInsets.navigationBars
    ) {
        for (navItem in navigationItemContentList) {
            NavigationBarItem(
                selected = currentTab == navItem.homeTabType,
                onClick = { onTabPressed(navItem.homeTabType) },
                icon = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Icon(
                            imageVector = navItem.icon, contentDescription = navItem.text
                        )
                        Text(text = navItem.text)
                    }
                },
                alwaysShowLabel = true,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}

@Preview
@Composable
fun PreviewOfCatalogItem() {
    CatalogItem(
        color = Color.Blue,
        painter = painterResource(id = R.drawable.trigonometry),
        textValue = "Trigonometry"
    )
}