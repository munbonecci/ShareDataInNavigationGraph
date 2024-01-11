package com.mun.bonecci.sharedatainnavigationgraph

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mun.bonecci.sharedatainnavigationgraph.navigation.NavigationItem

/**
 * [ScreenA] is a composable that represents the first screen of the app.
 * It allows the user to input their name and age through text fields.
 * Upon clicking the "Go to ScreenB" button, it navigates to ScreenB passing
 * the entered user name and age as arguments.
 *
 * @param navController The navigation controller to handle navigation actions.
 */
@Composable
fun ScreenA(navController: NavHostController) {
    // State variables to store user input for name and age
    var userName by remember { mutableStateOf(TextFieldValue()) }
    var userAge by remember { mutableStateOf(TextFieldValue()) }

    // Card composable for visual styling
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier
            .padding(all = 16.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
    ) {
        // Column to arrange UI components vertically
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Text field for entering user name
            TextField(
                value = userName,
                onValueChange = { userName = it },
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
                label = { Text("Enter your name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Text field for entering user age, restricting input to digits
            TextField(
                value = userAge,
                onValueChange = {
                    if (it.text.all { char -> char.isDigit() }) {
                        userAge = it
                    }
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                label = { Text("Enter your age") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )

            // Button to navigate to ScreenB with entered user data
            Button(
                onClick = {
                    if (userName.text.isNotEmpty() && userAge.text.toIntOrNull() != null) {
                        navController.navigate(
                            "${NavigationItem.ScreenB.route}/${userName.text}/${userAge.text.toIntOrNull() ?: 0}"
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            ) {
                Text("Go to ScreenB")
            }
        }
    }
}