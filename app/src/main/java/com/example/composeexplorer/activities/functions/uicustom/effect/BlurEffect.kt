package com.example.composeexplorer.activities.functions.uicustom.effect

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeexplorer.ui.theme.ComposeExplorerTheme

@Composable
fun BlurEffect() {

    var checked by remember { mutableStateOf(true) }
    val animatedBlur by animateDpAsState(
        targetValue = if (checked) 10.dp else 0.dp,
        label = ""
    )

    ComposeExplorerTheme {
        Surface {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier.blur(
                        radius = animatedBlur,
                        // Blur the lines around the text:
                        //edgeTreatment = BlurredEdgeTreatment.Unbounded
                        ),
                    text = "HELLO WORLD!!!",
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.displayLarge.fontSize,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center
                    )
                )
                Spacer(modifier = Modifier.height(24.dp))
                Switch(checked = checked, onCheckedChange = { checked = !checked })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BlurEffectPreview() {
    BlurEffect()
}