package com.example.democomposeapplication.ui

sealed class Screen(val route: String) {
    data object Data : Screen("data_screen")
    data object List : Screen("list_screen")


    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}