package com.example.liver.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.example.liver.screens.DonationOptionsScreen
import com.example.liver.screens.EvaluationProcessScreen
import com.example.liver.screens.HomeScreen
import com.example.liver.screens.LoginScreen
import com.example.liver.screens.PrivacyScreen
import com.example.liver.screens.RegisterScreen
import com.example.liver.screens.SplashScreen

private enum class AppScreen {
    Splash,
    Login,
    Register,
    Home,
    DonationOptions,
    EvaluationProcess,
    Privacy
}

@Composable
fun AppNavigation() {

    var currentScreen by rememberSaveable {
        mutableStateOf(AppScreen.Splash)
    }

    when (currentScreen) {

        AppScreen.Splash -> {
            SplashScreen(
                onLoginClick = {
                    currentScreen = AppScreen.Login
                },
                onRegisterClick = {
                    currentScreen = AppScreen.Register
                }
            )
        }

        AppScreen.Login -> {
            BackHandler {
                currentScreen = AppScreen.Splash
            }

            LoginScreen(
                onLoginSuccess = {
                    currentScreen = AppScreen.Home
                }
            )
        }

        AppScreen.Register -> {
            BackHandler {
                currentScreen = AppScreen.Splash
            }

            RegisterScreen()
        }

        AppScreen.Home -> {
            BackHandler {
                currentScreen = AppScreen.Splash
            }

            HomeScreen(
                onLearnAboutProcessClick = {
                    currentScreen = AppScreen.DonationOptions
                },
                onCheckEligibilityClick = {
                    currentScreen = AppScreen.DonationOptions
                }
            )
        }

        AppScreen.DonationOptions -> {
            BackHandler {
                currentScreen = AppScreen.Home
            }

            DonationOptionsScreen(
                onHomeClick = {
                    currentScreen = AppScreen.Home
                },
                onEvaluationProcessClick = {
                    currentScreen = AppScreen.EvaluationProcess
                }
            )
        }

        AppScreen.EvaluationProcess -> {
            BackHandler {
                currentScreen = AppScreen.DonationOptions
            }

            EvaluationProcessScreen(
                onNextClick = {
                    currentScreen = AppScreen.Privacy
                }
            )
        }

        AppScreen.Privacy -> {
            BackHandler {
                currentScreen = AppScreen.EvaluationProcess
            }

            PrivacyScreen(
                onNextClick = {
                    currentScreen = AppScreen.Home
                }
            )
        }
    }
}
