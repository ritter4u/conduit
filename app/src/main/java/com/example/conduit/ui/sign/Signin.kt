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
import com.example.conduit.ui.ViewModel.UserViewModel

@Suppress("PreviewAnnotationInFunctionWithParameters")
@Preview
@Composable
fun SignInScreen(
    signInViewModel: UserViewModel,
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
                    var useremail by remember { mutableStateOf("") }
                    var password by remember { mutableStateOf("") }
                    Text("Sign In")
                    OutlinedTextField(
                        value = useremail,
                        onValueChange = { useremail = it },
                        label = { Text("User Name") }
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
                        Button(onClick = {
                            signInViewModel.userLoginRequest(useremail,password)
//                            signInViewModel
//                            signInViewModel.userInfo.observe({lifecycle}){
//                                when(it){
//                                    is User ->{
//                                        Toast.makeText(requireContext(),"Logged in", Toast.LENGTH_LONG).show()
//                                        UserSharedpreferences(requireContext()).token=it.token
//                                        val intent = Intent(activity,AppHomeActivity::class.java)
//                                        startActivity(intent)
//                                        activity?.finish()
//
//                                    }
//                                    else ->{
//                                        Toast.makeText(requireContext(),"Login request is fail",
//                                            Toast.LENGTH_LONG).show()
//
//                                    }
//                                }
//                            }
                        }) {
                            Text("Sign In")
                        }

                        Button(onClick = { /* Do something! */ }) {
                            Text("Cancel")
                        }
                    }

                }
//            }
//        }
    }
}

