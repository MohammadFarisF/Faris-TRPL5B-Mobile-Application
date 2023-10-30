package com.farisfawwaz.faristrpl5bmobileapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.farisfawwaz.faristrpl5bmobileapplication.screens.About
import com.farisfawwaz.faristrpl5bmobileapplication.screens.ButtonColorViewModel
import com.farisfawwaz.faristrpl5bmobileapplication.screens.Help
import com.farisfawwaz.faristrpl5bmobileapplication.screens.Home
import com.farisfawwaz.faristrpl5bmobileapplication.ui.theme.FarisTRPL5BMobileApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FarisTRPL5BMobileApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ScreenMain()
                }
            }
        }
    }
}

@Composable
fun ScreenMain() {
    val navController = rememberNavController()
    val buttonColorViewModel = remember { ButtonColorViewModel() }

    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            Home(navController = navController, viewModel = buttonColorViewModel)
        }
        composable(Routes.About.route) {
            About(navController = navController)
        }
        composable(Routes.Help.route) {
            Help(navController = navController)
        }
    }
}
