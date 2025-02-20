package com.example.p1

import android.annotation.SuppressLint
import android.os.Bundle
import android.service.autofill.OnClickAction
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.VerticalAlignmentLine
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.p1.ui.theme.P1Theme
import kotlin.random.Random
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextField
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.text.NumberFormat
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            P1Theme {
            Surface(modifier = Modifier.fillMaxSize()) {
                GreetingPreview()
            }

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
//Tarjeta de presentacion
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
//Click limonada
@Composable
fun Limonada (){
    Column(Modifier.fillMaxSize(),verticalArrangement=Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
        var i by remember { mutableIntStateOf(0) }
        Image(painter =
        when(i){
            0->painterResource(R.drawable.limonero)
            1->painterResource(R.drawable.limon)
            2->painterResource(R.drawable.limonada)
            else->painterResource(R.drawable.vaso)},
        contentDescription = null,
        modifier = Modifier.size(300.dp,300.dp).clickable{ when(i){
            1->if(Random.nextInt()%5==0){i+=1}
            3->i=0
            else ->i+=1
        }

        })
        Spacer(Modifier.size(20.dp))
    Text(text= when(i){
        0->"Tap para recoger limon"
        1->"Click exprimir el limon"
        2->"Tap para beber limonada"
        else->"Tap para repetir"})
    }

}
@Composable
fun GreetingPreview() {
    P1Theme {
        //Start("Nombre completo","Titulo",604129535,"@njksadlks","dnsaidn@unirioja.es",R.drawable.ic_launcher_foreground)
        //Limonada()
        TipTimeLayout()

    }
}
    /*
     * Copyright (C) 2023 The Android Open Source Project
     *
     * Licensed under the Apache License, Version 2.0 (the "License");
     * you may not use this file except in compliance with the License.
     * You may obtain a copy of the License at
     *
     *      https://www.apache.org/licenses/LICENSE-2.0
     *
     * Unless required by applicable law or agreed to in writing, software
     * distributed under the License is distributed on an "AS IS" BASIS,
     * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
     * See the License for the specific language governing permissions and
     * limitations under the License.
     */
    //Propina
@Composable
fun TipTimeLayout() {
    var amountInput by remember { mutableStateOf("") }

    val amount = amountInput.toDoubleOrNull() ?: 0.0
    val tip = calculateTip(amount)

    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "stringResource(R.string.calculate_tip)",
            modifier = Modifier
                .padding(bottom = 16.dp, top = 40.dp)
                .align(alignment = Alignment.Start)
        )
        EditNumberField(
            value = amountInput,
            onValueChanged = { amountInput = it },
            modifier = Modifier.padding(bottom = 32.dp).fillMaxWidth()
        )
        Text(
            text = "tip",
            style = MaterialTheme.typography.displaySmall
        )
        Spacer(modifier = Modifier.height(150.dp))
    }
}

@Composable
fun EditNumberField(
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier
) {
    TextField(
        value = value,
        singleLine = true,
        modifier = modifier,
        onValueChange = onValueChanged,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}

/**
 * Calculates the tip based on the user input and format the tip amount
 * according to the local currency.
 * Example would be "$10.00".
 */
private fun calculateTip(amount: Double, tipPercent: Double = 15.0): String {
    val tip = tipPercent / 100 * amount
    return NumberFormat.getCurrencyInstance().format(tip)
}
}
