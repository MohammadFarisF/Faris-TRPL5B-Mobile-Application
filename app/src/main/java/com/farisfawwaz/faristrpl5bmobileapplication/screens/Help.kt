package com.farisfawwaz.faristrpl5bmobileapplication.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Help(navController: NavHostController) {
    var questionAndAnswers = listOf(
        "Apa itu Faris JBB App?\n" + "Faris JBB App adalah aplikasi hiburan yang menghasilkan beragam jokes bapak-bapak dan jokes receh. Aplikasi ini dibuat untuk menghibur pengguna dengan humor yang sederhana dan menggelitik.",
        "Apa yang membedakan Faris JBB App dari aplikasi hiburan lainnya?\n" + "Keunikan Faris JBB App terletak pada jenis humornya. Kami fokus pada jokes bapak-bapak dan jokes receh yang simpel namun lucu. Aplikasi ini dirancang untuk membuat pengguna tersenyum.",
        "Apakah Faris JBB App gratis?\n" + "Ya, Faris JBB App tersedia secara gratis untuk diunduh dan digunakan. Kami berusaha memberikan hiburan berkualitas tanpa biaya."
    )

    Column(
        modifier = Modifier.background(Color.White)
    ) {
        LazyColumn {
            items(questionAndAnswers) { questionAndAnswer ->
                val parts = questionAndAnswer.split("\n")
                val question = parts.getOrElse(0) { "" }
                val answer = parts.getOrElse(1) { "" }

                QuestionAndAnswerItem(question, answer)
            }
        }

        Button(
            onClick = { navController.popBackStack() },
            modifier = Modifier.padding(top = 9.dp, start = 8.dp),
            colors = ButtonDefaults.buttonColors(Color.Black)
        ) {
            Text(text = "Back to Home", color = Color.White)
        }
    }
}

@Composable
fun QuestionAndAnswerItem(question: String, answer: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White,
        ),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = question,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            var expanded by remember { mutableStateOf(false) }

            if (expanded) {
                Text(
                    text = answer,
                    style = MaterialTheme.typography.bodyLarge,
                    color = Color.Black
                )
                Text(
                    text = "Tutup Pertanyaan",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .clickable { expanded = false }
                        .padding(top = 3.dp),
                    color = Color.Red
                )
            } else {
                Text(
                    text = "Lihat Selengkapnya",
                    style = MaterialTheme.typography.bodySmall,
                    modifier = Modifier
                        .clickable { expanded = true }
                        .padding(top = 3.dp),
                    color = Color.Blue
                )
            }
        }
    }
}
