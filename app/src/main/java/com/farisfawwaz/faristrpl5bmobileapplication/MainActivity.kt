package com.farisfawwaz.faristrpl5bmobileapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
                    Greeting("Faris Fawwaz")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val gradient = Brush.linearGradient(
        0.0f to Color.Blue,
        50.0f to Color.White,
        start = Offset.Zero,
        end = Offset.Infinite
    )
    Box(modifier = Modifier.background(gradient).fillMaxSize())

        Text(
            text = "Hai Selamat Datang $name!",
            color = Color.White,
            modifier =Modifier.padding(30.dp),
            fontWeight = FontWeight.ExtraBold,
            fontSize = 30.sp

        )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FarisTRPL5BMobileApplicationTheme {
        Greeting("Android")
    }
}