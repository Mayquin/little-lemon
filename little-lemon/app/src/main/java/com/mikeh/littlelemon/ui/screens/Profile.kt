package com.mikeh.littlelemon.ui.screens

import android.content.Context
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.mikeh.littlelemon.ui.components.BaseButton
import com.mikeh.littlelemon.ui.components.CustomTopAppBar


/**
 * Created by Maycon Henrique on 26/01/2025.
 * maycon255@hotmail.com
 */

@Composable
fun Profile(){
    val packageName = LocalContext.current.packageName
    val sharedPreferences = LocalContext.current.getSharedPreferences(packageName, Context.MODE_PRIVATE)
    val name = sharedPreferences.getString("name", null) ?: ""
    val surname = sharedPreferences.getString("surname", null) ?: ""
    val email = sharedPreferences.getString("email", null) ?: ""

    Scaffold(topBar = { CustomTopAppBar() }) { paddingValues ->
        Column (Modifier.padding(paddingValues)) {
            Text(text = "Personal Information")
            Text(text = "First Name")
            Text(text = name)
            Text(text = "Surname")
            Text(text = surname)
            Text(text = "Email")
            Text(text = email)
            BaseButton(btnTitle = "Logout") {
                
            }
        }
    }
}

@Composable
@Preview
private fun ProfilePreview(){
    Profile()
}