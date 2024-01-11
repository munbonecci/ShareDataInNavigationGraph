package com.mun.bonecci.sharedatainnavigationgraph.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.navArgument
import androidx.navigation.compose.composable
import com.mun.bonecci.sharedatainnavigationgraph.ScreenA
import com.mun.bonecci.sharedatainnavigationgraph.ScreenB

/**
 * Composable function that defines the navigation graph using Jetpack Compose Navigation.
 *
 * @param navController The navigation controller that manages navigation within the graph.
 */
@Composable
fun NavigationGraph(navController: NavHostController) {
    // Create a navigation graph using NavHost
    NavHost(navController, startDestination = NavigationItem.ScreenA.route) {
        // Define the composable for ScreenA
        composable(NavigationItem.ScreenA.route) {
            // Call the appropriate ScreenA content here
            ScreenA(navController)
        }

        // Define the composable for ScreenB with a dynamic parameter (userName, userAge)
        composable(
            "${NavigationItem.ScreenB.route}/{userName}/{userAge}",
            arguments = listOf(
                navArgument("userName") { type = NavType.StringType },
                navArgument("userAge") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            // Retrieve the userName parameter from the arguments
            val userName = backStackEntry.arguments?.getString("userName")
            // Retrieve the userAge parameter from the arguments
            val userAge = backStackEntry.arguments?.getInt("userAge", 0)

            // Call the appropriate ScreenB content here, passing the userName and userAge
            ScreenB(userName, userAge)
        }
    }
}