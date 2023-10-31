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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@Composable
fun About(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        Column(modifier = Modifier
            .align(Alignment.Center)
            .padding(10.dp)) {
            Text(text = "Faris JBB App", fontSize = 24.sp, color = Color.Black)
            Text(text = "Versi 1.0", fontSize = 16.sp, color = Color.Black)
            Text(
                text = "Aplikasi ini digunakan untuk menghasilkan beragam joke receh yang cocok untuk bapak-bapak. Selamat menikmati humor receh!",
                fontSize = 16.sp,
                color = Color.Black
            )

            Button(
                onClick = { navController.popBackStack() },
                colors = ButtonDefaults.buttonColors(Color.Black),
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 25.dp)
            ) {
                Text(text = "Back to Home", color = Color.White)
            }
        }
    }
}