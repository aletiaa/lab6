package com.example.lab6_kotlin.widgets

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.lab6_kotlin.models.Input

@Composable
fun InputFields(input: Input, onInputChange: (Input) -> Unit) {
    var n by remember { mutableStateOf(input.n.toString()) }
    var Pn by remember { mutableStateOf(input.Pn.toString()) }
    var Un by remember { mutableStateOf(input.Un.toString()) }
    var cos by remember { mutableStateOf(input.cos.toString()) }
    var eta by remember { mutableStateOf(input.eta.toString()) }
    var Kv by remember { mutableStateOf(input.Kv.toString()) }
    var tg by remember { mutableStateOf(input.tg.toString()) }

    Column(modifier = Modifier.fillMaxWidth()) {
        TextField(value = n, onValueChange = {
            n = it
            onInputChange(input.copy(n = it.toInt()))
        }, label = { Text("n") })

        TextField(value = Pn, onValueChange = {
            Pn = it
            onInputChange(input.copy(Pn = it.toDouble()))
        }, label = { Text("Pn") })

        TextField(value = Un, onValueChange = {
            Un = it
            onInputChange(input.copy(Un = it.toDouble()))
        }, label = { Text("Un") })

        TextField(value = cos, onValueChange = {
            cos = it
            onInputChange(input.copy(cos = it.toDouble()))
        }, label = { Text("cos") })

        TextField(value = eta, onValueChange = {
            eta = it
            onInputChange(input.copy(eta = it.toDouble()))
        }, label = { Text("eta") })

        TextField(value = Kv, onValueChange = {
            Kv = it
            onInputChange(input.copy(Kv = it.toDouble()))
        }, label = { Text("Kv") })

        TextField(value = tg, onValueChange = {
            tg = it
            onInputChange(input.copy(tg = it.toDouble()))
        }, label = { Text("tg") })
    }
}