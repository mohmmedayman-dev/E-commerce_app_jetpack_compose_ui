package com.xll.e_commerceapp.ui.Activity

import android.view.LayoutInflater
import android.widget.EditText
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.xll.e_commerceapp.R

@Composable
fun Home(action: (id: String) -> Unit ) {


    LazyColumn{
        item { SearchXml() }
        item { topMenu() }
        item { offShoes() }
        item {  }
    }


}




@Composable
fun topMenu() {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically ) {
        itemMenu(R.drawable.grid,"All")
        itemMenu(R.drawable.hawaiian_shirt,"Clothing")
        itemMenu(R.drawable.accessories,"Accessories")
        itemMenu(R.drawable.shopping,"bags")
    }
}

@Composable
fun offShoes() {
    Card(shape = RoundedCornerShape(20.dp), modifier = Modifier
        .fillMaxWidth()
        .padding(20.dp)) {
        Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Column(modifier = Modifier
                    .padding(20.dp)
                    .background(shape = RoundedCornerShape(20.dp), color = Color(0xFFF3F3F3))) {
                    AsyncImage(model = R.drawable.discount, contentDescription = "", modifier = Modifier
                        .size(80.dp)
                        .padding(15.dp))
                }
                Column(modifier = Modifier, horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center) {
                    Text(text = "50% OFF", style = TextStyle(fontSize = 25.sp))
                    Text(text = "on cll women's shoes", style = TextStyle(fontSize = 15.sp))
                }
            }
            Box {}
            Icon(Icons.Filled.KeyboardArrowRight, contentDescription = "", modifier = Modifier
                .size(40.dp)
                .padding(end = 20.dp))
        }
    }
}


@Composable
fun itemMenu(icon : Int ,text: String){
      Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.padding(20.dp)) {
          Card(shape = RoundedCornerShape(250.dp), modifier = Modifier.size(70.dp)) {
              AsyncImage(modifier = Modifier.padding(20.dp) ,model = icon, contentDescription =  text, )
          }
          Text(text = text, modifier = Modifier.padding(7.dp))
      }
}

@Composable
fun SearchXml() {
    AndroidView(modifier = Modifier.fillMaxWidth(),
        factory = { context ->
            val view = LayoutInflater.from(context).inflate(R.layout.layout, null, false)
            val editText = view.findViewById<EditText>(R.id.edittext)

            // do whatever you want...
            view // return the view
        },
        update = {
            // Update the view
        }
    )
}