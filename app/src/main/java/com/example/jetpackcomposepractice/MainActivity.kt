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
                  //  Greeting("droid")
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

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "pOKO $name!",
        modifier = modifier
    )
}

@Composable
fun Yokojouna(modifier: Modifier = Modifier) {
    Text(
        text = "pO !",
        modifier = modifier
    )
}

@Composable
fun textViewInCompose() {

    Column {
        Text("Hello Beta") // default stype

        Text(
            text = "Hello GUGU",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(10.dp),
            color = Color.Blue,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Right,
            letterSpacing = 0.2.em,
            lineHeight = 28.sp
        )
    }
}


@Composable
fun myCustomButton() {

    // destructing like JS  two variables text = Click me | setText = Clicked
    val (text, setText) = remember {
        mutableStateOf("Click me")
    }
    Button(
        onClick = { setText("Clicked") }
    ) {
        Text(text)
    }
}

@Composable
fun MySwitch() {
    // State for the switch - true if the switch is on, false if it's off
    var isSwitchedOn by remember { mutableStateOf(false) }

    // A row with the Switch and a Text label
    Row(verticalAlignment = Alignment.CenterVertically) {
        // Switch composable with checked state and onCheckedChange lambda
        Switch(
            checked = isSwitchedOn,
            onCheckedChange = { isSwitchedOn = it }
        )
        Text(if (isSwitchedOn) "Switch is ON" else "Switch is OFF")
    }
}



@Composable
fun customSwitch() {

    // by means delegating the value of variable on remember block
    var isSwitchOn by remember { mutableStateOf(false)}

    Row(verticalAlignment = Alignment.CenterVertically) {
        Switch(checked = isSwitchOn, onCheckedChange = { isSwitchOn = it})
        Text(text = if(isSwitchOn) "Switch is on" else "Switch is off")
    }
}


@Composable
fun myCustomList() {

    val data = listOf("Item1", "Item2", "Item3", "Item4", "Item5")

    LazyColumn() {
        items(data) { item ->
            Text(item)
        }
    }
}


// Horizontal List

@Composable
fun myHorizontalList() {
    val data = listOf("Item1", "Item2", "Item3", "Item4", "Item5")

    LazyRow {
        items(data) { item ->
            Text(text= item, modifier = Modifier.padding(horizontal = 20.dp))
        }
    }
}

// Arranging UI components

@Composable
fun arrangingUIComponents() {
    Column {
        Text("Hello AJay")
        Text("Hello Raaje")

        Row {
            Text("Hello aaju")
            Text("Hello baaju")
        }
        Box { // seems like example of FrameLayout
            Text("Background")
            Text("Foreground")
        }



        //======== Modifier example

        Text( // modifier follows the builder pattern
            text = "Hello Ji",
            modifier = Modifier
                .border(2.dp, Color.Black)
                .background(Color.Red)
                .fillMaxWidth()
        )

        // .size(18.dp) it sets height and width
        Text(
            text = "New text",
            modifier = Modifier
                .background(Color.Blue)
                .size(80.dp)
        )

        Text(
            style = TextStyle(fontSize = 12.sp, fontFamily = FontFamily.Monospace),
            text="HappyHappy",
            modifier = Modifier
                .width(100.dp)
                .height(70.dp)
                .background(Color.LightGray)
        )
    }
}

// Concept - Constraint Layout

//"Flat view hierarchies" is a term used in UI development, particularly in the context of Android and web development,
//to describe a layout structure where the depth of the view tree is minimized. In a flat hierarchy,
//views are arranged with as few nested layers as possible. This concept is important for several reasons:

// advantage -- memory usage effectient, fast rendering, simpler layout, reduce overlapping of elements

//=============================================================

// benifits of Jetpack compose over traditional view system
// Simplicity, Readability, Efficiency (less biolerplate code), Simplified Codebase,
// Reactive UI Updates (better state management)
// Flat View Hierarchies
// Interoperability - can use with xml layouts
// Integration with Existing Architecture
// Preview Annotations
//Single Source of Truth: It encourages unidirectional data flow and state ownership,



//=========================
// Single source of truth concept

//lets take example we have two data sources  Rest API + Database Cache ----> Mobile app ( here data is updating in the mobile app from two differnt sources
// SSoT ->   Rest API -> Database Cachce -> Android app ( only database cache is responsible for data)


//===========================
//Advanced Usage
//ConstraintLayout in Compose allows for more complex arrangements:

//Chains: You can create horizontal or vertical chains for distributing elements equally or with weighted biases.
//Guidelines: Use guidelines for positioning elements relative to a fixed position or a percentage of the layout's dimension.
//Barrier: A barrier provides a way to align multiple elements based on the start, end, top, or bottom of the elements it references.


@Composable
fun myCustomConstraintLayout() {

    // add dependecy in build.gradle or directly from here
    // use for complex layout like creating Row inside Row inside Row ..so instead use Constraint layout
    // work same as xml
    //    implementation( "androidx.constraintlayout:constraintlayout-compose:1.0.1")
    // compose fun are of green color

    Column {

        ConstraintLayout {

            val (text1, text2) = createRefs()

            // Modifier.constainAs(text1) {} )
            Text("text1", Modifier.constrainAs(text1) {
                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(parent.start, margin = 10.dp)
            }
            )

            Text("text2", Modifier.constrainAs(text2) {
                top.linkTo(text1.bottom, margin = 10.dp)
                start.linkTo(parent.start, margin = 10.dp)
            }
            )
        }


        ConstraintLayout {

            val (button1, button2, button3) = createRefs()
        
            Button(
                onClick = {  },
                modifier = Modifier.constrainAs(button1) {top.linkTo(parent.top, margin = 10.dp)}
            ) {
                Text("Button1")
            }

            Button(
                onClick = {  },
                modifier = Modifier.constrainAs(button2)
                {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(button1.end, margin= 10.dp)
                }
            ) {
                Text("Button2")
            }

            Button(
                onClick = {  },
                modifier = Modifier.constrainAs(button3)
                {
                    top.linkTo(parent.top, margin = 10.dp)
                    start.linkTo(button2.end, margin= 10.dp)
                }
            ) {
                Text("Button3")
            }

            createHorizontalChain(button1, button2, button3, chainStyle = ChainStyle.Packed) //Packed  if chipka ke rakhna hai to
        }

        ConstraintLayout {

            val guideline = createGuidelineFromStart(0.3f)
            val (text1) = createRefs()

            Text("My New Text1", Modifier.constrainAs(text1) {
                top.linkTo(parent.top, margin = 10.dp)
                start.linkTo(guideline)
            }
            )
        }

        ConstraintLayout {
            val (text1, text2, button) = createRefs()

            Text("Long Text Here", Modifier.constrainAs(text1) {
                top.linkTo(parent.top, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            })

            Text("Short", Modifier.constrainAs(text2) {
                top.linkTo(text1.bottom, margin = 16.dp)
                start.linkTo(parent.start, margin = 16.dp)
            })

            // here we are creating barrier for button it should start after both texts end

            val endBarrier = createEndBarrier(text1, text2)
            Button(onClick = { /*TODO*/ }, Modifier.constrainAs(button) {
                start.linkTo(endBarrier, margin = 16.dp) // it should start from barrier
                top.linkTo(parent.top, margin = 16.dp)
            }) {
                Text("Button after Barrier")
            }
        }

    }
}

@Composable
fun customLoadingDialog() {

    Dialog( // white color dialog box.
        onDismissRequest = { /*TODO*/ },
        properties = DialogProperties(dismissOnClickOutside = false)
    ) { //putting framelayout inside it
        Box( // FrameLayout to put circular Loader in the Dialog
            modifier = Modifier
                .width(200.dp)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.White),
            contentAlignment = Alignment.Center

        ) { // putting loader inside Box
            CircularProgressIndicator(modifier = Modifier.padding(10.dp))
        }

    }
}

//=========================== Product List we are creating

data class Product(
    val id: Int,
    val title: String,
    val image:String
)

val productList = listOf(Product(1, "One","https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg")
    , Product(2, "Two", "https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg"))

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(text: String) {
    TopAppBar(
        title = {
            Text(text = text)
        },
        modifier = Modifier.shadow(
            elevation = 5.dp,
            spotColor = Color.DarkGray,
        )
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductsContent(
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { MyTopAppBar(text = "Products") }
    ) {
        LazyVerticalStaggeredGrid(
            modifier = Modifier.padding(top = it.calculateTopPadding()),
            columns = StaggeredGridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalItemSpacing = 10.dp
        ) {

            items(productList) { product ->
            ProductCard(product = product)
            }
        }
    }
}

@Composable
fun ProductCard(modifier: Modifier = Modifier, product: Product) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(modifier = Modifier.padding(15.dp)) {
            AsyncImage(
                model = product.image,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.FillBounds,
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = product.title, style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
fun ProductCard1(modifier: Modifier = Modifier, product: Product) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)

    ) {
        Column {
            AsyncImage (
                model = product.image,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth().aspectRatio(1f),
                contentScale = ContentScale.FillBounds
            )
            Text(text = product.title, style = MaterialTheme.typography.titleMedium)
        }
    }

}




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposePracticeTheme {
       // myCustomConstraintLayout()
       // HomeScreen()
       // customLoadingDialog()
       // ProductsContent()
       // ProductCard1(Modifier, productList)
    }
}