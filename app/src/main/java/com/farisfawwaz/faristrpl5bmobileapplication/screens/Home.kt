package com.farisfawwaz.faristrpl5bmobileapplication.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.farisfawwaz.faristrpl5bmobileapplication.Routes

class ButtonColorViewModel : ViewModel() {
    var buttonColor by mutableStateOf(Color.Black)
}

@Composable
fun Home(navController: NavHostController, viewModel: ButtonColorViewModel) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {
            Button(
                onClick = {
                    viewModel.buttonColor = Color(
                        red = (0..255).random(),
                        green = (0..255).random(),
                        blue = (0..255).random()
                    )
                },
                colors = ButtonDefaults.buttonColors(viewModel.buttonColor),
            ) {
                Text(text = "Change Button Color", color = Color.White)
            }
            Button(
                onClick = { navController.navigate(Routes.Jokes.route) },
                colors = ButtonDefaults.buttonColors(viewModel.buttonColor),
                modifier = Modifier.padding(start = 9.dp)
            ) {
                Text(text = "Navigate to Jokes", color = Color.White)
            }

            Button(
                onClick = { navController.navigate(Routes.About.route) },
                colors = ButtonDefaults.buttonColors(viewModel.buttonColor),
                modifier = Modifier.padding(start = 9.dp)
            ) {
                Text(text = "Navigate to About", color = Color.White)
            }

            Button(
                onClick = { navController.navigate(Routes.Help.route) },
                colors = ButtonDefaults.buttonColors(viewModel.buttonColor),
                modifier = Modifier.padding(start = 12.dp)
            ) {
                Text(text = "Navigate to Help", color = Color.White)
            }
        }
    }
}
