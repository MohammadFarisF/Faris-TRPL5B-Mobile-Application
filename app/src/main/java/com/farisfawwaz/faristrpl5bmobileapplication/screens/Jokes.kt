package com.farisfawwaz.faristrpl5bmobileapplication.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.farisfawwaz.faristrpl5bmobileapplication.JokesModal
import com.farisfawwaz.faristrpl5bmobileapplication.RetrofitAPI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Composable
fun Jokes(navController: NavHostController) {
    var joke by remember { mutableStateOf("Siap - Siap Ngakak KOCAK xixixi") }
    val scope = rememberCoroutineScope()

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
    ) {
        Column(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(10.dp)
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = Color.White,
                ),
                border = BorderStroke(2.dp, Color.Black),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Text(
                    text = joke,
                    modifier = Modifier.padding(16.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Center)
                    .padding(top = 200.dp, start = 20.dp, end = 25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Button(
                    onClick = {
                        // Tombol di-klik, ambil dad joke baru
                        scope.launch(Dispatchers.IO) {
                            val retrofit = Retrofit.Builder()
                                .baseUrl("https://api.npoint.io")
                                .addConverterFactory(GsonConverterFactory.create())
                                .build()
                            val service = retrofit.create(RetrofitAPI::class.java)

                            val call = service.getJokes()
                            val response: Response<List<JokesModal>> = call.execute()

                            if (response.isSuccessful) {
                                val jokes = response.body()
                                if (!jokes.isNullOrEmpty()) {
                                    val randomJoke = jokes.random()
                                    joke = randomJoke.text
                                }
                            } else {
                                joke = "Gagal mengambil lelucon, coba lagi nanti."
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(Color.Black),
                ) {
                    Text(text = "Generate Joke", color = Color.White)
                }
                Button(
                    onClick = { navController.popBackStack() },
                    colors = ButtonDefaults.buttonColors(Color.Black)
                ) {
                    Text(text = "Back to Home", color = Color.White)
                }
            }
        }
    }
