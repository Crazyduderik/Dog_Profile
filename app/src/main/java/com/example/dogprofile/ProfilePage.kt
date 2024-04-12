package com.example.dogprofile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.semantics.Role.Companion.Button
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
                .padding(top = 46.dp)
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
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            ProfileStats(count = "5000", title = "Followers")
            
            ProfileStats(count = "400", title = "Following")

            ProfileStats(count = "120", title = "Posts")
        }
        Row(horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)){
            ProfileButton(title = "Follow User")

            ProfileButton(title = "Message User")

        }
    }
}

@Composable
fun ProfileStats(count: String, title: String){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = count, fontWeight = FontWeight.Bold)
        Text(text = title)
    }
}

@Composable
fun ProfileButton(title:String){
    Button(onClick = {  }) {
        Text(text = title)
    }
}



@Preview(showBackground = true)
@Composable
fun ProfilePagePrev(){
    ProfilePage()
}



