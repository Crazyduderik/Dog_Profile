package com.example.dogprofile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension

@Composable
fun ProfilePage(){
    // card Eleveation card view
    Card(elevation = CardDefaults.cardElevation(defaultElevation = 6.dp), modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp, bottom = 100.dp, start = 16.dp, end = 16.dp)
        .border(width = 2.dp, color = Color.White, shape = RoundedCornerShape(30.dp))
    ) {

        BoxWithConstraints {
            val constraints = if(minWidth < 600.dp){
                portraitConstraints(margin = 16.dp)
            }else{
                // call landscape constraints
                landscapeConstraints(margin = 16.dp)
            }
            // Content of card : Including dog image, Description, Follower, etc
            ConstraintLayout(constraints){
                Image(painter = painterResource(id = R.drawable.doberman),
                    contentDescription = "doberman",
                    modifier = Modifier
                        .padding(top = 46.dp)
                        .size(200.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = Color.Magenta,
                            shape = CircleShape
                        )
                        .layoutId("image"),
                    // crop image
                    contentScale = ContentScale.Crop

                )
                Text(text = "Doberman",
                    Modifier.layoutId("nameText")
                )
                Text(text = "Germany",
                    Modifier.layoutId("originText")
                )

                Row(horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .layoutId("rowStats")

                ) {
                    ProfileStats(count = "5000", title = "Followers")

                    ProfileStats(count = "400", title = "Following")

                    ProfileStats(count = "120", title = "Posts")
                }
                Row(horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp)
                        .layoutId("rowButton")

                ){
                    ProfileButton(title = "Follow User")

                    ProfileButton(title = "Message User")
                }
            }
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


private fun portraitConstraints(margin:Dp): ConstraintSet{
    return ConstraintSet{
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val originText= createRefFor("originText")
        val rowStats = createRefFor("rowStats")
        val rowButton = createRefFor("rowButton")
        constrain(image){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(nameText){
            top.linkTo(image.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(originText){
            top.linkTo(nameText.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
        }
        constrain(rowStats){
            top.linkTo(originText.bottom)
        }
        constrain(rowButton){
            top.linkTo(rowStats.bottom)
        }
    }
}

private fun landscapeConstraints(margin: Dp): ConstraintSet{
    return ConstraintSet{
        val image = createRefFor("image")
        val nameText = createRefFor("nameText")
        val originText= createRefFor("originText")
        val rowStats = createRefFor("rowStats")
        val rowButton = createRefFor("rowButton")

        constrain(image){
            top.linkTo(parent.top, margin= margin)
            start.linkTo(parent.start,margin = margin)
        }
        constrain(nameText){
            start.linkTo(image.start)
            top.linkTo(image.bottom)
        }
        constrain(originText){
            top.linkTo(nameText.bottom)
            start.linkTo(nameText.start)
            end.linkTo(parent.end)
        }
        constrain(rowStats){
            top.linkTo(image.top)
            start.linkTo(image.end, margin = margin)
            end.linkTo(parent.end)
        }
        constrain(rowButton){
            top.linkTo(rowStats.bottom, margin = 16.dp)
            start.linkTo(rowStats.start)
            end.linkTo(parent.end)
            width = Dimension.wrapContent

        }

    }
}


@Preview(showBackground = true)
@Composable
fun ProfilePagePrev(){
    ProfilePage()
}



