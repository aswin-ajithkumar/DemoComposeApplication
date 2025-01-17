package com.example.democomposeapplication.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Print
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.navigation.NavController
import androidx.wear.compose.material.Text
import com.example.democomposeapplication.ui.Screen.Data.route

@SuppressLint("UnrememberedMutableState")
@Composable
fun Greeting(navController: NavController) {
    val snackBarHostState = SnackbarHostState()
    var textFieldValue by remember { mutableStateOf("") }
    /*val constraints = ConstraintSet {
        val text = createRefFor("text")
        val button = createRefFor("button")

        constrain(text) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
//            end.linkTo(parent.end)
            width = Dimension.value(100.dp)
            height = Dimension.value(100.dp)
        }
        constrain(button) {
            top.linkTo(text.bottom)
            start.linkTo(parent.start)
//            end.linkTo(parent.end)
            width = Dimension.matchParent
            height = Dimension.wrapContent
        }
    }*/
    Scaffold(
        topBar = {},
        bottomBar = {},
        floatingActionButton = {},
        snackbarHost = {
            SnackbarHost(snackBarHostState)
        }
    ) {
        ConstraintLayout(
            modifier = Modifier
                .padding(it)
                .padding(48.dp, 16.dp)
                .fillMaxSize(),
        ) {
            val (text, button, spacer) = createRefs()

            Box(
                modifier = Modifier
                    //.fillMaxWidth()
                    //.height(100.dp)
                    .constrainAs(text) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        width = Dimension.matchParent
                        height = Dimension.wrapContent
//            end.linkTo(parent.end)
                    },
            ) {
                OutlinedTextField(
                    value = textFieldValue,
                    onValueChange = {
                        textFieldValue = it
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .layoutId("text"),
                    placeholder = { Text("Enter your Name", color = Color.LightGray) },
                    singleLine = true
                )
            }

            Spacer(modifier = Modifier
                .size(10.dp)
                .constrainAs(spacer) {
                    top.linkTo(text.bottom)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                })

            Box(
                modifier = Modifier
                    .constrainAs(button) {
                        top.linkTo(spacer.bottom)
                        start.linkTo(parent.start)
                        end.linkTo(parent.end)
                        width = Dimension.matchParent
                        height = Dimension.wrapContent
                    }
            ) {
                Button(
                    onClick = {
                        Log.d("TextFieldValue", "Value: $textFieldValue")
                        val route = Screen.List.withArgs(textFieldValue)
                        Log.d("NavigationRoute", "Navigating to: $route")
                        navController.navigate(route)
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Icon(
                        imageVector = Icons.Default.Print,
                        contentDescription = "Search"
                    )
                    Text(
                        text = "Print",
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    Greeting()
//}