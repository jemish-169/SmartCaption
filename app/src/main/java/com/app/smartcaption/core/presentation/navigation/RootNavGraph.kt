package com.app.smartcaption.core.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.core.net.toUri
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.app.smartcaption.animation.AnimateScreen
import com.app.smartcaption.features.caption.presentation.CaptionScreen
import com.app.smartcaption.features.history.presentaion.HistoryScreen
import com.app.smartcaption.features.home.presentation.HomeScreen
import com.app.smartcaption.features.upload_img.presentaion.UploadScreen

@Composable
fun RootNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = RootRoute.HomeScreen
    ) {
        composable<RootRoute.HomeScreen>(
            popEnterTransition = AnimateScreen.rightPopEnterTransition(),
            enterTransition = AnimateScreen.leftEnterTransition(),
            popExitTransition = AnimateScreen.rightPopExitTransition(),
            exitTransition = AnimateScreen.leftExitTransition()
        ) {
            HomeScreen(
                onGetStarted = { navController.navigate(RootRoute.UploadScreen) },
                onHistoryClick = { navController.navigate(RootRoute.HistoryScreen) }
            )
        }

        composable<RootRoute.UploadScreen>(
            popEnterTransition = AnimateScreen.bottomPopEnterTransition(),
            enterTransition = AnimateScreen.topEnterTransition(),
            popExitTransition = AnimateScreen.bottomPopExitTransition(),
            exitTransition = AnimateScreen.topExitTransition()
        ) {
            UploadScreen(
                onClose = { navController.navigateUp() },
                onGenerateCaption = { imgUri ->
                    navController.navigate(
                        RootRoute.CaptionScreen(imgUri = imgUri.toString())
                    )
                }
            )
        }

        composable<RootRoute.CaptionScreen>(
            popEnterTransition = AnimateScreen.rightPopEnterTransition(),
            enterTransition = AnimateScreen.leftEnterTransition(),
            popExitTransition = AnimateScreen.rightPopExitTransition(),
            exitTransition = AnimateScreen.leftExitTransition()
        ) {
            val args = it.toRoute<RootRoute.CaptionScreen>()
            CaptionScreen(
                imgUri = args.imgUri.toUri(),
                onBack = { navController.navigateUp() }
            )
        }

        composable<RootRoute.HistoryScreen>(
            popEnterTransition = AnimateScreen.rightPopEnterTransition(),
            enterTransition = AnimateScreen.leftEnterTransition(),
            popExitTransition = AnimateScreen.rightPopExitTransition(),
            exitTransition = AnimateScreen.leftExitTransition()
        ) {
            HistoryScreen(onBack = { navController.navigateUp() })
        }
    }
}