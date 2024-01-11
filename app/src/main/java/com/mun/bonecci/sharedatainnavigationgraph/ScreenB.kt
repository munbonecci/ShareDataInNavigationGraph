package com.mun.bonecci.sharedatainnavigationgraph

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * ScreenB is a Composable function that displays a card with a welcome message
 * containing the user's name and age.
 *
 * @param userName The user's name received as a String.
 * @param userAge The user's age received as an Int.
 */
@Composable
fun ScreenB(userName: String?, userAge: Int?) {
    // Create a Card to provide visual styling
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        // Create a Box to center the content within the Card
        Box(
            modifier = Modifier
                .padding(32.dp),
            contentAlignment = Alignment.Center
        ) {
            // Display a Text with a welcome message containing the user's name and age
            Text(
                text = "Welcome, $userName! with Age: $userAge",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}