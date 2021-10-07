/*
 * Copyright 2020 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.conduit.ui

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.conduit.R
import com.example.conduit.ui.theme.conduitTheme

@Composable
fun AppDrawer(
    currentRoute: String,
    navigateToHome: () -> Unit,
//    navigateToInterests: () -> Unit,
    navigateToSignin: () -> Unit,
    navigateToSignup: () -> Unit,
    navigateToUpdateProfile: () -> Unit,
    navigateToSignout: () -> Unit,
    closeDrawer: () -> Unit
) {

    Column(modifier = Modifier.fillMaxSize()) {
        Spacer(Modifier.height(24.dp))
        conduitLogo(Modifier.padding(16.dp))
        Divider(color = MaterialTheme.colors.onSurface.copy(alpha = .2f))
        DrawerButton(
            icon = Icons.Filled.Home,
            label = stringResource(id = R.string.home_title),
            isSelected = currentRoute == MainDestinations.HOME_ROUTE,
            action = {
                navigateToHome()
                closeDrawer()
            }
        )

//        DrawerButton(
//            icon = Icons.Filled.ListAlt,
//            label = stringResource(id = R.string.interests_title),
//            isSelected = currentRoute == MainDestinations.INTERESTS_ROUTE,
//            action = {
//                navigateToInterests()
//                closeDrawer()
//            }
//        )
        //start sign
        DrawerButton(
            icon = Icons.Filled.Login,
            label = stringResource(id = R.string.signin_title),
            isSelected = currentRoute == MainDestinations.SIGN_IN_ROUTE,
            action = {
                navigateToSignin()
                closeDrawer()
            }
        )
        DrawerButton(
            icon = Icons.Filled.Assignment,
            label = stringResource(id = R.string.signup_title),
            isSelected = currentRoute == MainDestinations.SIGN_UP_ROUTE,
            action = {
                navigateToSignup()
                closeDrawer()
            }
        )
        //end sign
        DrawerButton(
            icon = Icons.Filled.AccountCircle,
            label = stringResource(id = R.string.signup_title),
            isSelected = currentRoute == MainDestinations.UPDATE_ROUTE,
            action = {
                navigateToUpdateProfile()
                closeDrawer()
            }
        )
        DrawerButton(
            icon = Icons.Filled.Logout,
            label = stringResource(id = R.string.signout_title),
            isSelected = currentRoute == MainDestinations.SIGN_OUT_ROUTE,
            action = {
                navigateToSignout()
                closeDrawer()
            }
        )
    }
}

@Composable
private fun conduitLogo(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        Image(
            painter = painterResource(R.drawable.ic_conduit_logo),
            contentDescription = null, // decorative
            colorFilter = ColorFilter.tint(MaterialTheme.colors.primary)
        )
        Spacer(Modifier.width(8.dp))
        Text(text = "Conduit")
    }
}

@Composable
private fun DrawerButton(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    action: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colors = MaterialTheme.colors
    val imageAlpha = if (isSelected) {
        1f
    } else {
        0.6f
    }
    val textIconColor = if (isSelected) {
        colors.primary
    } else {
        colors.onSurface.copy(alpha = 0.6f)
    }
    val backgroundColor = if (isSelected) {
        colors.primary.copy(alpha = 0.12f)
    } else {
        Color.Transparent
    }

    val surfaceModifier = modifier
        .padding(start = 8.dp, top = 8.dp, end = 8.dp)
        .fillMaxWidth()
    Surface(
        modifier = surfaceModifier,
        color = backgroundColor,
        shape = MaterialTheme.shapes.small
    ) {
        TextButton(
            onClick = action,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Image(
                    imageVector = icon,
                    contentDescription = null, // decorative
                    colorFilter = ColorFilter.tint(textIconColor),
                    alpha = imageAlpha
                )
                Spacer(Modifier.width(16.dp))
                Text(
                    text = label,
                    style = MaterialTheme.typography.body2,
                    color = textIconColor
                )
            }
        }
    }
}

@Preview("Drawer contents")
@Preview("Drawer contents (dark)", uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewAppDrawer() {
    conduitTheme {
        Surface {
            AppDrawer(
                currentRoute = MainDestinations.HOME_ROUTE,
                navigateToHome = {},
//                navigateToInterests = {},
                navigateToSignup ={},
                navigateToSignin ={},
                navigateToUpdateProfile={},
                navigateToSignout ={},
                closeDrawer = { }
            )
        }
    }
}
