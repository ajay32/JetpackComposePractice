package com.example.jetpackcomposepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.AsyncImage
import com.example.jetpackcomposepractice.ui.components.ArrangingUIComponents
import com.example.jetpackcomposepractice.ui.components.CardExample
import com.example.jetpackcomposepractice.ui.components.ConstraintLayoutExample
import com.example.jetpackcomposepractice.ui.components.CustomButton
import com.example.jetpackcomposepractice.ui.components.CustomLoadingDialog
import com.example.jetpackcomposepractice.ui.components.LazyRowAndColumnExample
import com.example.jetpackcomposepractice.ui.components.MySwitch
import com.example.jetpackcomposepractice.ui.components.TextExample
import com.example.jetpackcomposepractice.ui.screens.HomeScreen
import com.example.jetpackcomposepractice.ui.screens.LastScreen
import com.example.jetpackcomposepractice.ui.screens.SecondScreen
import com.example.jetpackcomposepractice.ui.theme.JetpackComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposePracticeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                 //  GreetingPreview() // if this is comment this method works
                //======================================================================================
                    val navHostController = rememberNavController()
                    
                   NavHost(navController = navHostController, startDestination = "home") {

                    // so we are define route here in composable it means if we have to go to HomeScreen i can tell this route "home"
                       composable("home") {
                           HomeScreen(navHostController = navHostController)
                       }

                       composable("second" + "/{url}/{counter}", // it says you can pass arguments like this to Second screen by using + with route you are passing
                           arguments = listOf(
                               navArgument("url") {    type = NavType.StringType },
                               navArgument("counter") {    type = NavType.IntType }
                           )
                       ) { backStackEntry ->
                           SecondScreen(navHostController = navHostController, backStackEntry)
                       }

                       composable("last") {
                           LastScreen(navHostController = navHostController)
                       }
                   }
                    
                }
            }
        }
    }
}


// You can directly run this method by selecting the method insted of app from config before the
// device shows in the toolbar then u do not need to call it from Surface {}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposePracticeTheme {
      //  ConstraintLayoutExample()
      //  CardExample()
     //   CustomLoadingDialog()
      //  ArrangingUIComponents()
       // MySwitch()
      //  LazyRowAndColumnExample()
       // CustomButton()
        TextExample()
    }
}