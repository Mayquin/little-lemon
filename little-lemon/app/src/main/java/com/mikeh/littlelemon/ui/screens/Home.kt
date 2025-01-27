package com.mikeh.littlelemon.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mikeh.littlelemon.R
import com.mikeh.littlelemon.api.model.MenuItemRoom
import com.mikeh.littlelemon.ui.components.BaseTextField
import com.mikeh.littlelemon.ui.components.CustomTopAppBar
import com.mikeh.littlelemon.ui.theme.HighlightBlack
import com.mikeh.littlelemon.ui.theme.HighlightWhite
import com.mikeh.littlelemon.ui.theme.PrimaryGreen
import com.mikeh.littlelemon.ui.theme.PrimaryYellow


/**
 * Created by Maycon Henrique on 26/01/2025.
 * maycon255@hotmail.com
 */

@Composable
fun Home(menuItems: List<MenuItemRoom>,
         categories: List<String>) {
    val stateMenuItems = remember {
        mutableStateOf(menuItems)
    }
    Scaffold(topBar = {
        CustomTopAppBar()
    }) { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {

            Column(
                modifier = Modifier
                    .background(PrimaryGreen)
                    .padding(20.dp)
            ) {
                Text(text = "Little Lemon", color = PrimaryYellow)
                Text(text = "Chicago", color = HighlightWhite)
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.fillMaxWidth(0.65f),
                        text = "We are a family-owned Mediterranean restaurant, focused on traditional recipes served with a modern twist",
                        color = HighlightWhite
                    )
                    Image(
                        modifier = Modifier
                            .size(width = 100.dp, height = 100.dp)
                            .clip(RoundedCornerShape(10.dp)),
                        painter = painterResource(id = R.drawable.hero_image),
                        contentScale = ContentScale.Crop,
                        contentDescription = ""
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                BaseTextField(value = "Enter search phrase", onValueChange = {

                })
            }

            Column {
                Text(text = "ORDER FOR DELIVERY!")
                LazyRow(horizontalArrangement = Arrangement.SpaceBetween) {
                    items(categories) { category ->
                        Button(onClick = {
                            stateMenuItems.value = menuItems.filter { it.category == category.lowercase() }
                        }) {
                            Text(text = category.replaceFirstChar {  it.uppercase() })
                        }
                    }
                }
            }


            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .padding(20.dp)
            ) {
                items (
                    items = stateMenuItems.value,
                    itemContent = { menuItem ->
                        Column {
                            Text(menuItem.title)
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Column (modifier = Modifier
                                    .fillMaxWidth(0.8f)
                                    .height(70.dp)) {
                                    Text(menuItem.description, maxLines = 2)
                                    Text(
                                        modifier = Modifier
                                            .weight(1f)
                                            .padding(5.dp),
                                        textAlign = TextAlign.Right,
                                        text = "$%.2f".format(menuItem.price)
                                    )
                                }

                                Image( modifier = Modifier
                                    .size(80.dp, 70.dp)
                                    .clip(
                                        RoundedCornerShape(10.dp)
                                    ),
                                    painter = painterResource(id = R.drawable.bruschetta),
                                    contentScale = ContentScale.FillBounds,
                                    contentDescription = "")
                            }
                        }
                        Divider(thickness = 1.dp,
                            color = HighlightBlack)
                    }
                )
            }
        }
    }
}

@Composable
@Preview
private fun HomePreview() {
    Home(listOf(
        MenuItemRoom(0,
            "Greek Salad",
            "The famous greek salad of crispy lettuce, peppers, olives and our Chicag..",
            12.99,
            "",
            "Dessert"
            ),
        MenuItemRoom(0,
            "Greek Salad",
            "The famous greek salad of crispy lettuce, peppers, olives and our Chicag..",
            12.99,
            "",
            "Dessert"
        )), listOf("Dessert","Dessert"))
}