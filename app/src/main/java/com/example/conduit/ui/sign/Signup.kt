package com.example.conduit.ui.sign

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.conduit.data.User
import com.example.conduit.ui.ViewModel.UserViewModel


@Suppress("PreviewAnnotationInFunctionWithParameters")
    @Preview
    @Composable
    fun SignUpScreen(
    signUpViewModel: UserViewModel,
    openDrawer: () -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState()
    ) {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        var username by remember { mutableStateOf("") }
        var useremail by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }
        Text("Sign Up")
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("User Name") }
        )
        OutlinedTextField(
            value = useremail,
            onValueChange = { useremail = it },
            label = { Text(text = "User Email") },
        )
        val passwordVisibility = false;
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
//                    visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
//                    onValueChange = { })
        )
        Divider()
        Row {
            val newuser: User =User(email=useremail,username=username,password=password,
                token = "", bio = "", image = "",)
            Button(onClick = {signUpViewModel.addUser(newuser)}) {
                Text("Sign Up")
            }

            Button(onClick = { /* Do something! */ }) {
                Text("Cancel")
            }
        }

    }
    }
