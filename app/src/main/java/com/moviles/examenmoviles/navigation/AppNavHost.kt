package com.moviles.examenmoviles.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.moviles.examenmoviles.data.MockSpaces
import com.moviles.examenmoviles.ui.screens.spaces.SpaceDetailScreen
import com.moviles.examenmoviles.ui.screens.spaces.SpacesListScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppDestinations.SPACES_LIST
    ) {
        composable(AppDestinations.SPACES_LIST) {
            SpacesListScreen(
                spaces = MockSpaces.spaces,
                onSpaceSelected = { spaceId ->
                    navController.navigate("${AppDestinations.SPACE_DETAIL}/$spaceId")
                }
            )
        }

        composable(
            route = "${AppDestinations.SPACE_DETAIL}/{spaceId}",
            arguments = listOf(
                navArgument("spaceId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->
            val spaceId = backStackEntry.arguments?.getInt("spaceId") ?: 0

            val selectedSpace = MockSpaces.spaces.firstOrNull {
                it.id == spaceId
            }

            selectedSpace?.let { space ->
                SpaceDetailScreen(
                    space = space,
                    onBack = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}