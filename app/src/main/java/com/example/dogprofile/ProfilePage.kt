package com.example.dogprofile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProfilePage(){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
        ) {
        Image(painter = painterResource(id = R.drawable.doberman),
            contentDescription = "doberman",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
                .border(
                    width = 2.dp,
                    color = Color.Red,
                    shape = CircleShape
                ),
            // crop image
            contentScale = ContentScale.Crop

            )
        Text(text = "Doberman")
        Text(text = "Germany")

        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "303", fontWeight = FontWeight.Bold)
                Text(text = "Followers")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "90", fontWeight = FontWeight.Bold)
                Text(text = "Following")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(text = "30", fontWeight = FontWeight.Bold)
                Text(text = "Posts")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ProfilePagePrev(){
    ProfilePage()
}



