package com.dobi.videogames.presentation.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {

    val viewModel: MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MessageCard("Mike")
        }
    }

    @Composable
    fun MessageCard(name: String) {
        Text(text = "Hello $name")
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(name = "Toolset")
    }
}