package com.example.jetpackcomposepractice.ui.compose_questions

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.navigation.NavController


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
