package com.mikeh.littlelemon.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview


/**
 * Created by Maycon Henrique on 26/01/2025.
 * maycon255@hotmail.com
 */

@Composable
fun BaseButton(btnTitle: String, onClick: () -> Unit){
    Button( modifier = Modifier.fillMaxWidth(),
        onClick = onClick) {
        Text(text = btnTitle)
    }
}

@Preview
@Composable
fun ButtonsPreview(){
    BaseButton("Test Button", { })
}