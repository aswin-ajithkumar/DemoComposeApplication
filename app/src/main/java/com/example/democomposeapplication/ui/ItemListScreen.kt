package com.example.democomposeapplication.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemList(name: String, navController:NavController) {

//    val scrollState = rememberScrollState()
    val snackBarHostState = SnackbarHostState()
    val scope = rememberCoroutineScope()
//    val canNavigateBack by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Item List")
                },
                actions = {
                    IconButton(onClick = {
                        scope.launch {
                            snackBarHostState.showSnackbar("Search Clicked")
                        }
                    }) {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    }
                },
                navigationIcon = {
//                    if (canNavigateBack){
                        IconButton(onClick = {
                            scope.launch {
                                snackBarHostState.showSnackbar("Back Clicked")
                                navController.navigateUp()
                            }
                        }) {
                            Icon(Icons.AutoMirrored.Default.KeyboardArrowLeft, contentDescription = "Go back")
                        }
//                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
//                    containerColor = Color.Red
                )
            )
        },
        bottomBar = {
            BottomAppBar(
                content = {
                    Text(text = "Bottom Bar")
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                scope.launch {
                    snackBarHostState.showSnackbar("FAB Clicked")
                }
            }) {
                Icon(Icons.Default.Edit, contentDescription = "Search")
            }
        },
        snackbarHost = {
            SnackbarHost(snackBarHostState)
        },
        floatingActionButtonPosition = FabPosition.EndOverlay
    ) {
        LazyColumn(modifier = Modifier.padding(it)) {
//            items(100) {
            itemsIndexed(
                listOf("This", "is", "Jetpack", "Compose", "Application", "for", "Android","Development", name)
            ) { _, string ->
                Text(
                    text = string,
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Light,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth(),
//                    Alignment = Alignment.CenterHorizontally,
//                    Arrangement = Arrangement.Center
                )
            }
        }
    }
//        Column(
//            modifier = Modifier
//                .verticalScroll(scrollState)
//                .padding(it)
//                .fillMaxSize()
//                .background(Color.White),
//            horizontalAlignment = CenterHorizontally,
//        ) {
//            for (i in 1..20) {
//                Text(
//                    text = "Item $i",
//                    fontSize = 40.sp,
//                    color = Color.Red,
//                    fontWeight = FontWeight.Normal,
//                    modifier = Modifier.padding(16.dp)
//                )
//            }
//        }
}


//@Preview(showBackground = true)
//@Composable
//fun ItemListPreview() {
//    ItemList()
//}