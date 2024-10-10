package com.example.sarahmalik_greetings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sarahmalik_greetings.ui.theme.SarahMalikGreetingsTheme

import android.annotation.SuppressLint
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SarahMalikGreetingsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "World",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

    @SuppressLint("SuspiciousIndentation")
    fun randomQuote(): String {
        val stringArray = arrayOf( // got the quotes from chatGPT
            "You only live once!",
            "Success is not final, failure is not fatal: It is the courage to continue that counts.",
            "The only limit to our realization of tomorrow is our doubts of today.",
            "The purpose of our lives is to be happy.",
            "Life is what happens when you're busy making other plans.",
            "Get busy living or get busy dying.",
            "You have within you right now, everything you need to deal with whatever the world can throw at you.",
            "Believe you can and you're halfway there.",
            "Do not watch the clock. Do what it does. Keep going.",
            "Keep your face always toward the sunshine—and shadows will fall behind you.",
            "It does not matter how slowly you go as long as you do not stop.",
            "Success usually comes to those who are too busy to be looking for it.",
            "Don't be afraid to give up the good to go for the great.",
            "I find that the harder I work, the more luck I seem to have.",
            "Opportunities don't happen, you create them.",
            "I failed my way to success.",
            "Don’t watch the clock; do what it does. Keep going.",
            "The best way to predict your future is to create it.",
            "Dream big and dare to fail.",
            "Your time is limited, don't waste it living someone else's life.",
            "The only way to do great work is to love what you do."
        )
        val quote = Random.nextInt(stringArray.size)
        return stringArray[quote] // returns random quote
    }

    @Composable
    fun Greeting(name: String, modifier: Modifier = Modifier) {
        var quote by remember {
            mutableStateOf(value = "You only live once!") // state of the view
        }
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = quote,
                fontSize = 20.sp, // hello world text placement
                modifier = Modifier.height(90.dp) // button placement
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                quote = randomQuote()
            }) {
                Text(
                    text = "Click me", // text of the button
                    fontSize = 20.sp
                )
            }
        }
    }


    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        SarahMalikGreetingsTheme {
            Greeting("Android")
        }
    }
