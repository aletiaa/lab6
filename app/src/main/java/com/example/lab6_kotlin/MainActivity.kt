package com.example.lab6_kotlin

import android.os.Bundle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lab6_kotlin.models.Input
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lab6_kotlin.ui.theme.Lab6_kotlinTheme
import androidx.compose.runtime.livedata.observeAsState
import com.example.lab6_kotlin.widgets.InputFields
import com.example.lab6_kotlin.widgets.Result

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6_kotlinTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen(viewModel: HomeView = viewModel()) {
    val grindingMachine = viewModel.inputGrindingMachine.observeAsState(Input())
    val groutingMachine = viewModel.inputGroutingMachine.observeAsState(Input())
    val circularSaw = viewModel.inputCircularSaw.observeAsState(Input())
    val press = viewModel.inputPress.observeAsState(Input())
    val polishingMachine = viewModel.inputPolishingMachine.observeAsState(Input())
    val shaper = viewModel.inputShaper.observeAsState(Input())
    val fan = viewModel.inputFan.observeAsState(Input())
    var showDialog by remember { mutableStateOf(false) }
    var results by remember { mutableStateOf<Map<String, String>>(emptyMap()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Text("Enter values for Grinding Machine")
        InputFields(input = grindingMachine.value) { newInput ->
            viewModel.inputGrindingMachine.value = newInput
        }

        Text("Enter values for Grouting Machine")
        InputFields(input = groutingMachine.value) { newInput ->
            viewModel.inputGroutingMachine.value = newInput
        }

        Text("Enter values for Circular Saw")
        InputFields(input = circularSaw.value) { newInput ->
            viewModel.inputCircularSaw.value = newInput
        }

        Text("Enter values for Press")
        InputFields(input = press.value) { newInput ->
            viewModel.inputPress.value = newInput
        }

        Text("Enter values for Polishing Machine")
        InputFields(input = polishingMachine.value) { newInput ->
            viewModel.inputPolishingMachine.value = newInput
        }

        Text("Enter values for Shaper")
        InputFields(input = shaper.value) { newInput ->
            viewModel.inputShaper.value = newInput
        }

        Text("Enter values for Fan")
        InputFields(input = fan.value) { newInput ->
            viewModel.inputFan.value = newInput
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = {
            results = viewModel.calculate()
            showDialog = true
        }) {
            Text("Calculate")
        }

        Spacer(modifier = Modifier.height(16.dp))

    }

    if (showDialog) {
        Result(results = results, onDismiss = { showDialog = false })
    }
}






