package com.ouca.android

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CounterView(counterViewModel: CounterViewModel) {
    // var count by remember { mutableStateOf(0) }
    val count by counterViewModel.count.collectAsState()
    val countLVL by counterViewModel.countLVL.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {

        Button(
            onClick = { counterViewModel.incrementCount() },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Increment")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { counterViewModel.decrementCount() },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "Decrement")
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { counterViewModel.initialyseCount() },
            modifier = Modifier.width(200.dp)
        ) {
            Text(text = "initialize")
        }

        Spacer(modifier = Modifier.height(200.dp))

        Row (
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(align = Alignment.CenterVertically)
        ){
            Button(
                onClick = { counterViewModel.incrementCount() },
                modifier = Modifier.width(50.dp).height(50.dp)
            ) {
                Text(text = "+")
            }
            Box(
                modifier = Modifier
                    .size(240.dp, 50.dp)
                    .background(
                        color = Color.LightGray,
                    ),

                contentAlignment = Alignment.Center,
                ) {
                LinearProgressIndicator(
                    progress = count / 100,
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.primary
                )

                Text(
                    text = "level ${countLVL}  |  ${(count).toInt()}%",
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.onBackground,
                )
            }
        }
    }
}