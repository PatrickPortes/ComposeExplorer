package com.example.composeexplorer.activities

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeexplorer.activities.functions.ExpandableCard
import com.example.composeexplorer.activities.functions.GoogleButton
import com.example.composeexplorer.activities.functions.GradientButton
import com.example.composeexplorer.R
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme
import com.example.composeexplorer.ui.theme.CustomColor1
import com.example.composeexplorer.ui.theme.CustomColor2

class MainActivity3 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeExplorerTheme {
                Column(
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background)
                        .padding(23.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    ExpandableCard(
                        textTitle = "My Title",
                        description = "Lorem ipsum dolor sit amet consectetur adipiscing elit, urna consequat" +
                                " felis vehicula class ultricies mollis dictumst, aenean non a in donec" +
                                " nulla. Phasellus ante pellentesque erat cum risus consequat imperdiet" +
                                " aliquam, integer placerat et turpis mi eros nec lobortis taciti," +
                                " vehicula nisl litora tellus ligula porttitor metus."
                    )
                    Column(
                        modifier = Modifier
                            .padding(20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        TestTextField()
                        Spacer(modifier = Modifier.height(30.dp))
                        GoogleButton(
                            text = "Sign Up with Google",
                            loadingText = "Creating Account...",
                            onClicked = { Log.d("Google Button", "Clicked") }
                        )
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TestTextField() {

    var text by remember {
        mutableStateOf("Type Your Email Here...")
    }

    TextField(
        value = text,
        onValueChange = { newText ->
            text = newText
        },

        //Disable TextField:
        //enabled = false

        //Just Copy Text Enable:
        //readOnly = true

        //Label Title on the Top of the TextField:
        label = { Text(text = "Email:") },

        //Single/Multiple Lines:
        singleLine = true,
        //maxLines = 2

        //Start/Leading and End/Trailing Icon:
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email Icon"
                )
            }
        },
        trailingIcon = {
            IconButton(onClick = {
                Log.d("Trailing Icon", "Clicked")
            }) {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = "Check Icon"
                )
            }
        },

        //Others TextFields Types:

        //Keyboard Options:
        keyboardOptions = KeyboardOptions(
            //Type Field:
            keyboardType = KeyboardType.Email,
            //The keyboard's 'Enter' button Icon:
            imeAction = ImeAction.Done
        ),

        //Keyboard Actions:
        keyboardActions = KeyboardActions(
            //Verify when the imeAction Button is Clicked:
            onSearch = {
                Log.d("ImeAction", "Clicked")
            }
        )
    )

    //OutLine TextField:
    OutlinedTextField(value = text,
        onValueChange = { newText ->
            text = newText
        },

        label = { Text(text = "Edit:") },

        singleLine = true,

        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = "Edit Icon"
                )
            }
        })

    //Basic TextField:

    BasicTextField(
        modifier = Modifier
            .padding(16.dp)
            .background(Color.LightGray),
        value = text,
        onValueChange = { newText ->
            text = newText
        }
    )

    //Password TextField:

    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }

    val icon = if (passwordVisibility) {
        painterResource(id = R.drawable.baseline_visibility_24)
    } else {
        painterResource(id = R.drawable.baseline_visibility_off_24)
    }

    OutlinedTextField(
        value = password,
        onValueChange = {
            password = it
        },
        placeholder = { Text(text = "Password") },
        label = { Text(text = "Password") },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility = !passwordVisibility
            }) {
                Icon(
                    painter = icon,
                    contentDescription = if (passwordVisibility) "Hide Password" else "Show Password",
                    tint = Color.Gray
                )
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            keyboardType = KeyboardType.Password,
            capitalization = KeyboardCapitalization.None
        )
    )

    //Character Count Limit on Text Field:

    var name by remember { mutableStateOf("") }
    val maxChar = 10

    OutlinedTextField(
        value = name,
        onValueChange = {
            if (it.length <= maxChar) {
                name = it
            }
        },
        label = { Text(text = "Name") },
        placeholder = { Text(text = "Enter Your Name") },
        maxLines = 1
    )

}

@Preview(showBackground = true)
@Composable
fun TestThreePreview() {
    ComposeExplorerTheme {
        Column(
            Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(23.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            ExpandableCard(
                textTitle = "My Title",
                description = "Lorem ipsum dolor sit amet consectetur adipiscing elit, urna consequat" +
                        " felis vehicula class ultricies mollis dictumst, aenean non a in donec" +
                        " nulla. Phasellus ante pellentesque erat cum risus consequat imperdiet" +
                        " aliquam, integer placerat et turpis mi eros nec lobortis taciti," +
                        " vehicula nisl litora tellus ligula porttitor metus."
            )
            Column(
                modifier = Modifier
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(25.dp)
            ) {
                TestTextField()
                Spacer(modifier = Modifier.height(10.dp))
                GoogleButton(
                    text = "Sign Up with Google",
                    loadingText = "Creating Account...",
                    onClicked = { Log.d("Google Button", "Clicked") }
                )
                GradientButton(
                    text = "Gradient Button",
                    textColor = Color.White,
                    gradient = Brush.horizontalGradient(
                        colors = listOf(
                            CustomColor1,
                            CustomColor2
                        )
                    )
                ) { }
            }
        }
    }
}