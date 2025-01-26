package com.mikeh.littlelemon.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mikeh.littlelemon.R
import com.mikeh.littlelemon.ui.components.BaseButton
import com.mikeh.littlelemon.ui.components.BaseTextField
import com.mikeh.littlelemon.ui.theme.HighlightWhite
import com.mikeh.littlelemon.ui.theme.PrimaryGreen

/**
 * Created by Maycon Henrique on 26/01/2025.
 * maycon255@hotmail.com
 */

@Composable
fun Onboarding() {
    Scaffold(topBar = {
        Row(
            Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                modifier = Modifier.size(width = 150.dp, height = 50.dp),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "logo"
            )
        }
    }) { paddingValues ->
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
                    textAlign = TextAlign.Center
                )
            }
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                Text(
                    text = "Personal Information",
                    modifier = Modifier.fillMaxWidth()
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
                BaseButton(btnTitle = "Register") {
                    
                }
            }
        }
    }
}


@Composable
@Preview
fun OnboardingPreview() {
    Onboarding()
}