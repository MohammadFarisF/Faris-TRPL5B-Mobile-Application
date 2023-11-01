package com.farisfawwaz.faristrpl5bmobileapplication

sealed class Routes(val route: String) {
    object Home : Routes("home")
    object About : Routes("about")
    object Help : Routes("help")
    object Jokes : Routes("jokes")
}