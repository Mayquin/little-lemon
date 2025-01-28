package com.mikeh.littlelemon.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mikeh.littlelemon.ui.components.BaseButton
import com.mikeh.littlelemon.ui.components.BaseTextField
import com.mikeh.littlelemon.ui.components.CustomTopAppBar
import com.mikeh.littlelemon.ui.screens.navigation.NavigationItem
import com.mikeh.littlelemon.ui.theme.HighlightWhite
import com.mikeh.littlelemon.ui.theme.PrimaryGreen

/**
 * Created by Maycon Henrique on 26/01/2025.
 * maycon255@hotmail.com
 */

@Composable
fun Onboarding(navController: NavHostController) {
    Scaffold(topBar = { CustomTopAppBar() }) { paddingValues ->
        val name = remember {
            mutableStateOf("")
        }
        val surname = remember {
            mutableStateOf("")
        }
        val email = remember {
            mutableStateOf("")
        }
        Column(
            Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Box(
                modifier = Modifier
                    .height(80.dp)
                    .background(PrimaryGreen),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Let's get to know you",
                    modifier = Modifier.fillMaxWidth(),
                    color = HighlightWhite,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Normal,
                    fontSize = 24.sp
                )
            }
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(40.dp)
            ) {
                Text(
                    text = "Personal Information",
                    modifier = Modifier.fillMaxWidth(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                BaseTextField(title = "First Name",
                    value = name.value,
                    onValueChange = {
                        name.value = it
                    }
                )
                BaseTextField(title = "Last Name",
                    value = surname.value,
                    onValueChange = {
                        surname.value = it
                    }
                )
                BaseTextField(title = "Email",
                    value = email.value,
                    onValueChange = {
                        email.value = it
                    }
                )
                Spacer(modifier = Modifier.weight(1f))
                BaseButton(btnTitle = "Register") {
                    if (name.value.isEmpty() ||
                        surname.value.isEmpty() ||
                        email.value.isEmpty()) {
                        return@BaseButton
                    }

                    navController.navigate(NavigationItem.Home.route)
                }
            }
        }
    }
}


@Composable
@Preview
private fun OnboardingPreview() {
    Onboarding(rememberNavController())
}