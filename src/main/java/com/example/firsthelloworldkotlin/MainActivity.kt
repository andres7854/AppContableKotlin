package com.example.firsthelloworldkotlin

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.firsthelloworldkotlin.ui.theme.FirstHelloWorldKotlinTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            
            com.example.firsthelloworldkotlin.Preview()

        }

    }

}

//UI of the application

@Composable
fun MyText(toWrite: String, color: Color, style: TextStyle){

    Text(toWrite, color = color, style = style, modifier = Modifier
        .fillMaxWidth()
        .wrapContentWidth(Alignment.CenterHorizontally)
    )

}

//string values

var stringValuesArray:ArrayList<String> = arrayListOf()
var actualInputId: Int = 0
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyInput(label: String){

    var inputId: Int by remember {mutableStateOf(0)}

    if (stringValuesArray.isNotEmpty() && stringValuesArray.count() > actualInputId){

        stringValuesArray.add("")
        actualInputId += 1
        inputId = actualInputId

    }else{

        stringValuesArray.add("")
        actualInputId += 1

    }

    var text: String by remember { mutableStateOf("") }

    OutlinedTextField(value = text, onValueChange = {  text = it  }, label = { Text(text = label) }, modifier = Modifier
        .fillMaxWidth()
        .wrapContentWidth(Alignment.CenterHorizontally)
    )

    Button(onClick = { println(inputId)}) { }

    stringValuesArray[inputId] = text

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDisabledInput(label: String){

    OutlinedTextField(value = "", onValueChange = { },label = { Text(text = label) }, modifier = Modifier
        .fillMaxWidth()
        .wrapContentWidth(Alignment.CenterHorizontally)
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showSystemUi = true)
@Preview(showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun Preview() {

    FirstHelloWorldKotlinTheme {

        Scaffold(
            topBar= {
                Row(modifier = Modifier
                    .background(Color.Gray)
                    .padding(10.dp)){
                    MyText("NOMINAPP", MaterialTheme.colorScheme.onBackground, MaterialTheme.typography.titleLarge)
                }
            }
        ){ contentPadding ->

            Box(modifier = Modifier.padding(contentPadding)) {

                Column(modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .verticalScroll(
                        rememberScrollState()
                    )) {

                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(5.dp)
                    ){

                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                        ){

                            MyText("VALORES PARA LA NOMINA", MaterialTheme.colorScheme.onBackground, MaterialTheme.typography.titleLarge)
                            Spacer(modifier = Modifier.height(2.dp))
                            MyInput("dias a trabajar")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyInput("cantidad del auxilio de transporte")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyInput("porcentaje del aporte a eps")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyInput("porcentaje del aporte a pension")
                            Spacer(modifier = Modifier.height(2.dp))

                        }

                    }

                    Row(modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxWidth()
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .padding(5.dp)
                    ){

                        Column(modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.CenterHorizontally)
                        ){

                            MyText("NOMINA", MaterialTheme.colorScheme.onBackground, MaterialTheme.typography.titleLarge)

                            MyInput("salario basico:")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyInput("dias")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyDisabledInput("salario trabajado:")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyInput("horas extra:")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyInput("comisiones:")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyDisabledInput("auxilio de transporte:")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyDisabledInput("total devengado:")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyDisabledInput("aporte de eps:")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyDisabledInput("aporte de pension:")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyInput("prestamo:")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyDisabledInput("fondo solidario:")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyDisabledInput("total deducido:")
                            Spacer(modifier = Modifier.height(2.dp))
                            MyDisabledInput("total a pagar")
                            Spacer(modifier = Modifier.height(2.dp))
                        }

                    }

                }

            }

        }

    }

}

//calculation functions

