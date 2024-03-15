package com.example.maths_tutor_app.domain.navigation

import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.maths_tutor_app.presentation.ui.authenticationScreen.loginScreen.LogInScreen
import com.example.maths_tutor_app.presentation.ui.authenticationScreen.signupScreen.SignUpScreen
import com.example.maths_tutor_app.presentation.ui.splashScreen.SplashScreen
import com.example.maths_tutor_app.presentation.ui.welcomeScreen.WelcomeScreen

enum class AppScreens(val route: String) {
    SplashScreen(route = "splash_screen"), AppWelcomeScreen(route = "welcome_screen"), LoginScreen(
        route = "login_screen"
    ),
    SignupScreen(route = "signup_Screen"), HomeLessonsCatalogScreen(route = "home_lessons_catalog_screen"), HomeMyCourseCatalogScreen(
        route = "home_myCourse_catalog_screen"
    ),
    HomeMyProfileScreen(route = "home_myProfile_screen"), QuizScreen(route = "quiz_screen")

}

@Composable
fun NavigationManager(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = AppScreens.SplashScreen.route) {
        composable(route = AppScreens.SplashScreen.route) {
            SplashScreen {
                navController.navigate(route = AppScreens.AppWelcomeScreen.route) {
                    popUpTo(AppScreens.SplashScreen.route) {
                        inclusive = true
                    }
                }
            }
        }
        composable(route = AppScreens.AppWelcomeScreen.route, enterTransition = {
            slideInVertically(
                initialOffsetY = { it }, // Start from bottom of screen
                animationSpec = tween(500, 0, LinearEasing)
            ) + fadeIn(tween(500, 0, LinearEasing), 0f)
        }, exitTransition = {
            slideOutVertically(
                targetOffsetY = { it }, animationSpec = tween(500, 0, LinearEasing)
            ) + fadeOut(tween(500, 0, LinearEasing), 0f)

        }) {
            WelcomeScreen(modifier = Modifier.fillMaxSize()) {
                navController.navigate(route = AppScreens.LoginScreen.route) {
                    /*  if(userHasLoggedIn)
                      popUpTo(AppScreens.SplashScreen.route) {
                          inclusive = true
                      }
                     */
                }
            }
        }
        composable(route = AppScreens.LoginScreen.route, enterTransition = {
            slideInVertically(
                initialOffsetY = { it }, // Start from bottom of screen
                animationSpec = tween(500, 0, LinearEasing)
            ) + fadeIn(tween(500, 0, LinearEasing), 0f)
        }, exitTransition = {
            slideOutVertically(
                targetOffsetY = { it }, animationSpec = tween(500, 0, LinearEasing)
            ) + fadeOut(tween(500, 0, LinearEasing), 0f)

        }) {
            LogInScreen(onLoginClicked = {
                navController.navigate(route = AppScreens.HomeLessonsCatalogScreen.route)
            }, onSignUpClicked = {
                navController.navigate(route = AppScreens.SignupScreen.route)
            })
        }
        composable(route = AppScreens.SignupScreen.route, enterTransition = {
            slideInVertically(
                initialOffsetY = { it }, // Start from bottom of screen
                animationSpec = tween(500, 0, LinearEasing)
            ) + fadeIn(tween(500, 0, LinearEasing), 0f)
        }, exitTransition = {
            slideOutVertically(
                targetOffsetY = { it }, animationSpec = tween(500, 0, LinearEasing)
            ) + fadeOut(tween(500, 0, LinearEasing), 0f)

        }) {
            SignUpScreen(onLoginClick = {
                navController.popBackStack()
            }, onTC_click = {
                Toast.makeText(context, "T&C", Toast.LENGTH_SHORT).show()
            }) {
                navController.navigate(route = AppScreens.HomeLessonsCatalogScreen.route)
            }
        }
        composable(route = AppScreens.HomeLessonsCatalogScreen.route, enterTransition = {
            slideInVertically(
                initialOffsetY = { it }, // Start from bottom of screen
                animationSpec = tween(500, 0, LinearEasing)
            ) + fadeIn(tween(500, 0, LinearEasing), 0f)
        }, exitTransition = {
            slideOutVertically(
                targetOffsetY = { it }, animationSpec = tween(500, 0, LinearEasing)
            ) + fadeOut(tween(500, 0, LinearEasing), 0f)

        }) {
            Surface(modifier = Modifier.fillMaxSize()) {

            }
        }
    }

}

