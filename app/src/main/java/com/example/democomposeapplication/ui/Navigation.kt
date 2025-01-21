package com.example.democomposeapplication.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun Navigation() {
    val navController = rememberNavController()
//    val canNavigateBack by remember { mutableStateOf(false) }

    NavHost(navController = navController, startDestination = Screen.Data.route) {

        composable(route = Screen.Data.route) {
            Greeting(navController)
        }

        composable(
            route = Screen.List.route + "/{name}",
            arguments = listOf(
                navArgument("name") {
                    type = NavType.StringType
                    defaultValue = "Android" // Default value
                    nullable = false
                }
            ),

        ) { entry ->
            val name = entry.arguments?.getString("name") ?: "Default"
            ItemList(name = name, navController)
        }
    }
}

//
//@Composable
//fun LoginScreen(navController: NavController) {
//    Column(
//        verticalArrangement = Arrangement.Center,
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(horizontal = 18.dp, vertical = 48.dp)
//    ) { }
//}