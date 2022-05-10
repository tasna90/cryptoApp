package com.example.cryptoapp.presentation.splash

import androidx.compose.runtime.*
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.airbnb.lottie.compose.*
import com.example.cryptoapp.R
import com.example.cryptoapp.presentation.Screen

@Composable
fun SplashScreen(
    navController: NavController,
    splashViewModel: SplashViewModel = hiltViewModel()
) {
    val state = splashViewModel.state.value

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.splash_rocket))

    val logoAnimationState = animateLottieCompositionAsState(
        composition = composition,
        isPlaying = true
    )
    LottieAnimation(
        composition = composition,
        progress = logoAnimationState.progress
    )

    if (!state.isLoading) {
        LaunchedEffect(Unit) {
            navController.navigate(Screen.CoinListScreen.route) {
                popUpTo(Screen.SplashScreen.route) {
                    inclusive = true
                }
            }
        }
    }
}