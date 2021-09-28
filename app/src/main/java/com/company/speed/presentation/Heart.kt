package com.company.speed.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun Heart(
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val centerX = this.constraints.maxWidth / 2
        val centerY = this.constraints.maxHeight / 2
        val unitLength = 50
        SmallTriangle(
            unitLength = 100,
            degreeRotation = 45f,
            topLeftX = 50.dp,
            topLeftY = 100.dp,
            color = Color.Red
        )
        SmallTriangle(
            unitLength = 100,
            degreeRotation = 45f,
            topLeftX = 69.dp,
            topLeftY = 50.dp,
            color = Color.Red
        )
        LargeTriangle(
            preUnitLength = 100,
            degreeRotation = 0f,
            topLeftX = 50,
            topLeftY = 300,
            color = Color.Blue
        )
        LargeTriangle(
            preUnitLength = 100,
            degreeRotation = 0f,
            topLeftX = 50,
            topLeftY = 300,
            color = Color.Blue
        )
        MediumTriangle(
            preUnitLength = 100,
            degreeRotation = 0f,
            topLeftX = 50,
            topLeftY = 300,
            color = Color.Yellow
        )
        Parallelogram(
            unitLength = 100,
            degreeRotation = 45f,
            topLeftX = 50,
            topLeftY = 300,
            color = Color.Black
        )
        Square(
            unitLength = unitLength,
            degreeRotation = 45f,
            topLeftX = (centerX),
            topLeftY = (centerY),
            color = Color.Magenta
        )
    }
}