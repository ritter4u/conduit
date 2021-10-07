package com.example.conduit.ui.profile

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.conduit.ui.ViewModel.UserViewModel

@Suppress("PreviewAnnotationInFunctionWithParameters")
@Preview
@Composable
fun UpdateProfileScreen(
    userViewModel: UserViewModel,
    openDrawer: () -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
//    val (currentSection, updateSection) = rememberSaveable { mutableStateOf(tabContent.first().section) }
//    conduitTheme {
//        ProvideWindowInsets {
    Scaffold(

    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ){

            var image_link by remember { mutableStateOf("") }
            var username by remember { mutableStateOf("") }
            var bio by remember { mutableStateOf("") }
            var useremail by remember { mutableStateOf("") }
            var password by remember { mutableStateOf("") }

            Text("Update Profile")
            OutlinedTextField(
                value = image_link,
                onValueChange = { image_link = it },
                label = { Text("Url of Profile Picture") }
            )

            val passwordVisibility = false;
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "User Name") },
//                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
//                    onValueChange = { })
            )
            OutlinedTextField(
                value = bio,
                onValueChange = { bio = it },
                label = { Text(text = "Bio") },
//                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
//                    onValueChange = { })
            )
            OutlinedTextField(
                value = useremail,
                onValueChange = { useremail = it },
                label = { Text(text = "User Email") },
//                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
//                    onValueChange = { })
            )
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "New Password") },
//                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
//                    onValueChange = { })
            )
            Divider()
            Row {
                Button(onClick = {

//                    userViewModel

                }) {
                    Text("Update Settings")
                }

                Button(onClick = { /* Do something! */ }) {
                    Text("LogOut")
                }
            }

        }
//            }
//        }
    }
}

