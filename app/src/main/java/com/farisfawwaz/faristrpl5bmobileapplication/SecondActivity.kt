package com.farisfawwaz.faristrpl5bmobileapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.farisfawwaz.faristrpl5bmobileapplication.ui.theme.FarisTRPL5BMobileApplicationTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FarisTRPL5BMobileApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Mohammad Faris Fawwaz")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val colors = listOf(Color.Blue, Color(0xFF0066FF), Color.White)
    val gradient = Brush.verticalGradient(
        colors,
        startY = 0.0f,
        endY = 2600.0f
    )

    Column(modifier = Modifier
        .fillMaxSize()
        .background(gradient)) {
        Text(
            text = "Hai Selamat Datang $name!",
            color = Color.White,
            modifier = Modifier.padding(30.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp
        )
    }
}

