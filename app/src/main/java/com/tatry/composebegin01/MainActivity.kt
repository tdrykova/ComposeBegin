package com.tatry.composebegin01

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tatry.composebegin01.ui.theme.ComposeBegin01Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBegin01Theme {
                Grid()
            }
        }
    }
}

@Composable
fun Grid(modifier: Modifier = Modifier) {
    Column(modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Card(
                title = stringResource(R.string.text_composable_title),
                description = stringResource(R.string.text_composable_description),
                color = 0xFFEADDFF,
                pos = 0
            )

            Card(
                title = stringResource(R.string.image_composable_title),
                description = stringResource(R.string.img_desc),
                color = 0xFFD0BCFF,
                pos = 1
            )
        }

        Row( modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
                verticalAlignment = Alignment.CenterVertically
        ) {

            Card(
                title = stringResource(R.string.row_composable_title),
                description = stringResource(R.string.row_desc),
                color = 0xFFB69DF8,
                pos = 2
            )

            Card(
                title = stringResource(R.string.image_composable_title),
                description = stringResource(R.string.img_desc),
                color = 0xFFF6EDFF,
                pos = 3
            )

        }
    }

}

@Composable
fun Card(title: String, description: String, color: Long, pos: Int) {
    when (pos) {
        0, 2 -> {
            Box(modifier = Modifier
                .fillMaxHeight()
                .fillMaxWidth(0.5F)
                .background(Color(color)),
                contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Text(
                        text = description,
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
        1, 3 -> {
            Box(modifier = Modifier
                .fillMaxHeight()
                .fillMaxSize()
                .background(Color(color)),
                contentAlignment = Alignment.Center) {
                Column(
                    modifier = Modifier
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )

                    Text(
                        text = description,
                        textAlign = TextAlign.Justify
                    )
                }
            }
        }
    }


}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun GreetingPreview() {
    ComposeBegin01Theme {
        Grid()
    }
}