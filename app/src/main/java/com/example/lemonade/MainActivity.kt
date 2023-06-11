package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    LemonadeApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LemonadeApp(modifier: Modifier = Modifier) {
    var result by remember { mutableStateOf(1) }
    var squeezeText by remember { mutableStateOf(1) }

    Surface(
        modifier = modifier.fillMaxSize(),
        onClick = {
            if(result <= 4) {
            result ++
            if (result == 4){
                result = 1
            }
        }
            if(squeezeText <= 4) {
                squeezeText ++
                if (squeezeText == 4){
                    squeezeText = 1
                }
            }
                  },
    ) {
        Column(
            modifier = modifier,
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,

            ){

            Text(
                text = when (squeezeText) {
                    1 -> stringResource(R.string.Lemon_tree)
                    2 -> stringResource(R.string.Lemon)
                    3 -> stringResource(R.string.Glass_of_Lemonade)
                    else -> stringResource(R.string.Empty_glass)
                }
            )

            Spacer( modifier = modifier.padding(16.dp))

            DisplayItems(result)

        }
        
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DisplayItems(digit: Int ,modifier: Modifier = Modifier){

    Card(
        modifier = modifier,
        shape = RoundedCornerShape(size = 30.dp),

        ){
        when (digit){
            1 -> CardItems(R.drawable.lemon_tree)
            2 -> CardItems(R.drawable.lemon_squeeze)
            3 -> CardItems(R.drawable.lemon_drink)
            else -> CardItems(R.drawable.lemon_restart)
        }
    }
}


@Composable
fun CardItems(
    @DrawableRes displayText: Int ,
    modifier: Modifier = Modifier
){
    Column(
        modifier = modifier
            .padding(60.dp)
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = displayText), contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LemonadeTheme {
        LemonadeApp()
    }
}