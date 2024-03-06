package com.example.jetpackcomposepractice.ui.compose_questions

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavController
import kotlinx.coroutines.delay
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import android.os.Handler
import android.widget.Toast


//1. How do you optimize memory usage in Jetpack Compose?
//To optimize memory usage in Jetpack Compose, you should:

//Use lazy composables like LazyColumn and LazyRow to only instantiate visible items.
//Minimize the scope of state: Keep the scope of state objects as limited as possible to prevent unnecessary recompositions.
//Avoid large collections in memory: If dealing with large datasets, consider paginating [Flow] (asking server to return 20 items at a time) or dynamically loading the data.
//Profile memory usage: Use tools like Android Studio's Profiler to identify and reduce memory leaks or excessive memory use.



//Recycle and reuse objects: Use remember to keep objects in memory during recomposition rather than creating new ones.
@Composable
fun InefficientComposable() {
    // This list gets recreated on every recomposition
    val options = listOf("Option 1", "Option 2", "Option 3")
    OptionsMenu(options)
}

@Composable
fun OptionsMenu(options: List<String>) {
    // Displays options
}


@Composable
fun EfficientComposable() {
    // The list is remembered and only created once
    val options = remember { listOf("Option 1", "Option 2", "Option 3") }
    OptionsMenu(options)
}


//AAAAAAAAAAAAAA

//4. Describe the use of channels and flows with Jetpack Compose.
//Channels and Flows can be used to handle asynchronous stream of data:
//
//Flow for UI state: Use StateFlow or SharedFlow to represent UI state that can be collected as state in composables.
//Channels for event communication: Use channels to communicate events between different parts of your application, especially useful for one-time events like navigation or snackbars.


//===================================

//7. Discuss the role of snapshot state and its impact on performance.

//Snapshot state in Jetpack Compose is a part of the system's design and is applied automatically to manage and observe state changes within your composable functions.
//You don't have to apply it manually. Whenever you use state management primitives provided by Compose, such as mutableStateOf, remember, and viewModel,
//you are implicitly utilizing the snapshot state system.


//val counter = mutableStateOf(0)

@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }

    Button(onClick = { count.value++ }) {
        Text("Count is ${count.value}")
    }
}

//==============================


//How do you secure data and manage permissions in Jetpack Compose apps?
//
//1. Secure Data Storage
//Encrypted SharedPreferences: For storing small pieces of data securely, use EncryptedSharedPreferences which encrypts keys and values.
//Room Database with Encryption: When storing larger amounts of structured data, use Room with SQLCipher to encrypt your SQLite database.
//Secure Files: For files, consider using the EncryptedFile class from the Android Security library to read and write encrypted files to the internal storage.
//
//1. Secure Data Storage
//Encrypted SharedPreferences: For storing small pieces of data securely, use EncryptedSharedPreferences which encrypts keys and values.
//Room Database with Encryption: When storing larger amounts of structured data, use Room with SQLCipher to encrypt your SQLite database.
//Secure Files: For files, consider using the EncryptedFile class from the Android Security library to read and write encrypted files to the internal storage.
//
//import com.google.accompanist.permissions.ExperimentalPermissionsApi
//import com.google.accompanist.permissions.rememberPermissionState
//
//@OptIn(ExperimentalPermissionsApi::class)
//@Composable
//fun CameraPermissionExample() {
//    // Remember the camera permission state
//    val cameraPermissionState = rememberPermissionState(android.Manifest.permission.CAMERA)
//
//    when {
//        cameraPermissionState.hasPermission -> {
//            // Permission granted, show camera UI
//        }
//        cameraPermissionState.shouldShowRationale -> {
//            // Explain why the permission is needed, include a button to request permission
//        }
//        !cameraPermissionState.hasPermission -> {
//            // Permission is not granted, request it
//            LaunchedEffect(true) {
//                cameraPermissionState.launchPermissionRequest()
//            }
//        }
//    }
//}
//


//HTTPS and SSL: Always use HTTPS for network communication. Implement SSL pinning with OkHttp to prevent man-in-the-middle attacks.
//Token Handling: Securely handle authentication tokens by avoiding their exposure. Store them securely using encrypted storage.

//4. Data Encryption
//Jetpack Security (JetSec): Use the Jetpack Security library to encrypt data before saving it locally. This is especially useful for sensitive information.
//Cryptography API: Utilize Android’s Cryptography API for encrypting data in transit or at rest.


//5. Using Android’s BiometricPrompt for Authentication
//Leverage BiometricPrompt for biometric authentication, adding an extra layer of security for sensitive features within your app.


// What is a Scaffold in Jetpack Compose and how is it used?
//A Scaffold in Jetpack Compose is a layout component that implements the basic material design visual layout structure.

//Key Components of a Scaffold
//TopBar: A top app bar that displays information and actions relating to the current screen.
//BottomBar: A bottom navigation bar that allows navigation between top-level destinations in the app.
//FloatingActionButton: A circular button that triggers a primary action in your application.
//Drawer: A navigation drawer that slides in from the side, typically used for app navigation.
//SnackBar: A temporary message that appears at the bottom of the screen.
//Content: The main content area for the current screen's UI components.

//==============================================


//how to use composable with xml together ?
//
//<androidx.compose.ui.platform.ComposeView
//android:id="@+id/compose_view"
//android:layout_width="match_parent"
//android:layout_height="wrap_content"/>
//
//// Find the ComposeView
//val composeView = findViewById<ComposeView>(R.id.compose_view)
//
//// Set the Composable content
//composeView.setContent {
//    Greeting(name = "Android")
//}
//

//====================
//How to send data in jetpack compose to other scrren ?
//
//composable("secondScreen/{data}") { backStackEntry ->
//    SecondScreen(backStackEntry.arguments?.getString("data"))
//}
//
//@Composable
//fun FirstScreen(navController: NavController) {
//    Button(onClick = {
//        navController.navigate("secondScreen/dataToSend")
//    }) {
//        Text("Go to Second Screen")
//    }
//}
//
//======================================
//Describe the recomposition process in Jetpack Compose?
//UI to update dynamically in response to state changes
//It's the process by which Compose re-invokes @Composable functions to redraw the UI with the updated state

//===============================================================
//DisposableEffect is a powerful tool in Jetpack Compose used for managing side effects that require cleanup when a composable leaves the composition or when the keys to the effect change

//like we are destroying the activity..so need to remove the handler call back


@Composable
fun TimerExample() {
    val context = LocalContext.current

    // Suppose we want to show a toast every 5 seconds
    DisposableEffect(Unit) {
        val handler = Handler()
        val runnable = object : Runnable {
            override fun run() {
                Toast.makeText(context, "Timer tick!", Toast.LENGTH_SHORT).show()
                handler.postDelayed(this, 5000) // Schedule this to run again in 5 seconds
            }
        }

        // Start the timer
        handler.post(runnable)

        // Cleanup function: will be called when the composable leaves the composition
        // or when the inputs to the DisposableEffect change.
        onDispose {
            handler.removeCallbacks(runnable) // Stop the timer
        }
    }

    // Rest of your UI
}

//==================================================================
//what is launchedEffect in jetpack compose ?
//Use for Asynchronous Work
//in Jetpack Compose is a side-effect API designed for launching and managing coroutines within composable functions.
//ties the lifecycle of the coroutine to the composable's lifecycle.
//This means the coroutine automatically cancels when the composable is removed from the composition or when the keys passed to LaunchedEffect change, ensuring resource safety and avoiding memory leaks.
//
//
//Scoped to Composable's Lifecycle
//LaunchedEffect takes a set of keys as parameters. The coroutine inside will be canceled and restarted if any of the keys change, allowing it to react to changes in its environment.
//



@Composable
fun FetchDataExample() {
    LaunchedEffect(Unit) { // Using Unit as key for simplicity; the coroutine will not restart based on state changes
        // Simulate data fetching
        val data = fetchData()
        // Use the data for something, like updating state
    }
}

suspend fun fetchData(): String {
    delay(2000) // Simulate network delay
    return "Data from network"
}
//-------

//LaunchedEffect(key1, key2, ...) {

//========================================================================
//what is state hoisting in jetpack compose ?
//State hoisting in Jetpack Compose is a pattern that involves moving the state up to a parent composable, making the child composable stateless (or less stateful).
//This pattern is used to make composables more reusable and easier to manage by centralizing state management in higher-level composables
//
//Controlled Components: The child composable becomes a controlled component. It does not manage its own state but receives its state from a parent composable and notifies the parent about any events that should update the state.
//Unidirectional Data Flow:
//Reusability and Testability:
//
//
//In this example, the Counter composable manages its own state.
//This makes Counter less reusable because its state management is tightly coupled with its UI logic.
@Composable
fun Counter1() {
    var count by remember { mutableStateOf(0) }

    Button(onClick = { count++ }) {
        Text("Count is $count")
    }
}

//------------------

//The Counter composable becomes stateless, receiving its state (count) and what to do on increment (onIncrement) as parameters.
//The ParentComposable now manages the state of count, making the Counter composable more reusable and easier to control from outside.

@Composable
fun Counter(count: Int, onIncrement: () -> Unit) {
    Button(onClick = onIncrement) {
        Text("Count is $count")
    }
}

@Composable
fun ParentComposable() {
    var count by remember { mutableStateOf(0) }
    Counter(count = count, onIncrement = { count++ })
}

//=============================================================================

//how to do animations in jetpack compose ?
//Animations in Jetpack Compose can be created using a variety of built-in animation APIs that cater to different use cases, from simple property animations to more complex transition-based animations.
//
//for animating simple properties like size, color, rotation, etc., Compose offers straightforward APIs like animateContentSize, animateColor
//
//

//@Composable
//fun ColorChangeAnimation() {
//    var isSelected by remember { mutableStateOf(false) }
//    val backgroundColor by animateColorAsState(
//        targetValue = if (isSelected) Color.Red else Color.Blue
//    )
//
//    Box(modifier = Modifier
//        .size(100.dp, 100.dp)
//        .background(backgroundColor)
//        .clickable { isSelected = !isSelected })
//}
//
////-------------
//animate multiple properties simultaneously, you can use the Animatable API.
//
//@Composable
//fun MoveAnimation() {
//    val coroutineScope = rememberCoroutineScope()
//    val offsetX = remember { Animatable(0f) }
//
//    Box(modifier = Modifier
//        .size(100.dp, 100.dp)
//        .background(Color.Green)
//        .clickable {
//            coroutineScope.launch {
//                offsetX.animateTo(targetValue = if (offsetX.value == 0f) 100f else 0f, animationSpec = tween(durationMillis = 1000))
//            }
//        }
//        .offset(x = offsetX.value.dp))
//}
//
////---------------------------
//For complex animations involving multiple states and properties, the transition API provides a powerful mechanism to define and manage animations declaratively.
//
//
//@Composable
//fun ComplexAnimation() {
//    var isSelected by remember { mutableStateOf(false) }
//    val transition: Transition<Boolean> = updateTransition(targetState = isSelected, label = "")
//
//    val color by transition.animateColor(label = "") { state ->
//        if (state) Color.Red else Color.Blue
//    }
//    val size by transition.animateDp(label = "") { state ->
//        if (state) 48.dp else 24.dp
//    }
//
//    Box(
//        contentAlignment = Alignment.Center,
//        modifier = Modifier
//            .size(size)
//            .background(color)
//            .clickable { isSelected = !isSelected }
//            .animateContentSize(animationSpec = tween(1000))
//    ) {
//        BasicText("Tap Me", Modifier.padding(8.dp))
//    }
//}
//