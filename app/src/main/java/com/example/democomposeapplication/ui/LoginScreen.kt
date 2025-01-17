package com.example.democomposeapplication.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment.Companion.BottomCenter
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.democomposeapplication.R
import com.example.democomposeapplication.ui.theme.DemoComposeApplicationTheme
import kotlinx.coroutines.launch

@Composable
fun LoginScreen() {
    val buttonText = "Login With Facebook"
    val logoPainter = painterResource(id = R.drawable.icons8_x)
    val fontFamily = FontFamily(
        Font(R.font.athiti_bold, FontWeight.Bold),
        Font(R.font.athiti_semibold, FontWeight.SemiBold),
        Font(R.font.athiti_medium, FontWeight.Medium),
        Font(R.font.athiti_regular, FontWeight.Normal),
        Font(R.font.athiti_light, FontWeight.Light),
        Font(R.font.athiti_extralight, FontWeight.ExtraLight)
    )
//    val scaffoldState = rememberScaffoldState()
    val snackBarHostState = SnackbarHostState()
    val scope = rememberCoroutineScope()
    Scaffold(
        topBar = {},
        bottomBar = {},
        floatingActionButton = {},
        snackbarHost = {
            SnackbarHost(snackBarHostState)
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = CenterHorizontally,
        ) {
            BackgroundDesign(
                modifier = Modifier.weight(1f),
                painter = painterResource(id = R.drawable.bg_image),
                contentDescription = "",
                fontFamily = fontFamily
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                contentAlignment = BottomCenter
            ) {
                LoginButton(
                    painter = logoPainter,
                    text = buttonText,
                    onClick = {
                        scope.launch {
                            snackBarHostState.showSnackbar("hello")
                        }
                    }
                )
            }
        }
    }
//    Surface(
//        modifier = Modifier
//            .background(Color.White)
//            .fillMaxSize()
//    ) {
//    }

}

@Composable
fun BackgroundDesign(
    modifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    fontFamily: FontFamily
) {
    ElevatedCard(
        modifier = modifier,
        shape = RoundedCornerShape(bottomEnd = 30.dp, bottomStart = 30.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent, Color.White
                            ),
                            startY = 1000f
                        )
                    ),
                contentAlignment = Center
            ) {
                Text(
                    text = buildAnnotatedString {
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontSize = 30.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.Normal
                            )
                        ) {
                            append("J")
                        }
                        append("etpack ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontSize = 30.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.Normal
                            )
                        ) {
                            append("C")
                        }
                        append("ompose ")
                        withStyle(
                            style = SpanStyle(
                                color = Color.White,
                                fontSize = 30.sp,
                                fontFamily = fontFamily,
                                fontWeight = FontWeight.Normal
                            )
                        ) {
                            append("A")
                        }
                        append("pplication")
                    },
                    color = Color.Black,
                    fontSize = 25.sp,
                    fontFamily = fontFamily,
                    fontWeight = FontWeight.Medium,
                    textDecoration = TextDecoration.Underline
                )
            }
        }
    }
}

@Composable
fun LoginButton(
    modifier: Modifier = Modifier,
    painter: Painter,
    text: String,
    onClick: () -> Unit
) {
    ElevatedButton(
        onClick = onClick,
        modifier = modifier.padding(16.dp)
    ) {
        Icon(
            painter = painter,
            contentDescription = "Drawable Icon",
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(18.dp))
        Text(text)
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    DemoComposeApplicationTheme {
        LoginScreen()
    }
}
