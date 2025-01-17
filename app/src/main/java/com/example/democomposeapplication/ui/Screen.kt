package com.example.democomposeapplication.ui

sealed class Screen(val route: String) {
    object Data : Screen("data_screen")
    object List : Screen("list_screen")


    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}