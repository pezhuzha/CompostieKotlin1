package com.example.p1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p1.ui.theme.P1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P1Theme {/*
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }*/
            }
            GreetingPreview()
        }
    }
}
@Composable
fun GreetingImage() {
    Image(
        painter=painterResource( R.drawable.ic_launcher_foreground),
        contentDescription = null,
        modifier=Modifier.fillMaxSize()
    )

}


@Composable
fun Start(
    name: String,
    title: String,
    phonenum: Int,
    socialmedia: String,
    email: String,
    image:Int
) {
    Column (Modifier.fillMaxSize().padding(10.dp,100.dp),verticalArrangement=Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        Column(Modifier.padding(20.dp).fillMaxWidth(),verticalArrangement=Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
            Image(painter=painterResource( R.drawable.ic_launcher_foreground),
                contentDescription = null,
                Modifier.size(100.dp,100.dp),
                alignment = Alignment.Center)
            Text(text = name,
                textAlign = TextAlign.Center,
                fontSize = 30.sp)
            Text(text=title,
                fontSize = 20.sp,
                textAlign = TextAlign.Center)

        }
        Spacer(Modifier.size(100.dp))
        Column (Modifier.padding(20.dp).fillMaxWidth(),verticalArrangement=Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Row {
                Image(painter=painterResource(image),
                    contentDescription = null,
                    Modifier.size(20.dp,20.dp))
                Text(text = phonenum.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(alignment = Alignment.CenterVertically))}
            Row {
                Image(painter=painterResource( image),
                    contentDescription = null,
                    Modifier.size(20.dp,20.dp))
                Text(text = socialmedia,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)) }
            Row {
                Image(painter=painterResource( image),
                    contentDescription = null,
                    Modifier.size(20.dp,20.dp))
                Text(text = email,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(alignment = Alignment.CenterVertically)) }
        }
    }

}

@Composable
fun GreetingPreview() {
    P1Theme {
        Start("Nombre completo","Titulo",604129535,"@njksadlks","dnsaidn@unirioja.es",R.drawable.ic_launcher_foreground)
    }
}