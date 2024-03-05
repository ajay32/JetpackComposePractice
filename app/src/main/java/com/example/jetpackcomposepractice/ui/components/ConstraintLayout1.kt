package com.example.jetpackcomposepractice.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout


//===========================
//Advanced Usage
//ConstraintLayout in Compose allows for more complex arrangements:

//Chains: You can create horizontal or vertical chains for distributing elements equally or with weighted biases.
//Guidelines: Use guidelines for positioning elements relative to a fixed position or a percentage of the layout's dimension.
//Barrier: A barrier provides a way to align multiple elements based on the start, end, top, or bottom of the elements it references.




// add dependecy in build.gradle or directly from here
// use for complex layout like creating Row inside Row inside Row ..so instead use Constraint layout
// work same as xml
//    implementation( "androidx.constraintlayout:constraintlayout-compose:1.0.1")
// compose fun are of green color
@Composable
fun ConstraintLayoutExample() {
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