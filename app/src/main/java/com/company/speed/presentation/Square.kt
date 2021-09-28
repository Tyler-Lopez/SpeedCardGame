package com.company.speed.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Square(
    unitLength: Int,
    degreeRotation: Float,
    topLeftX: Int,
    topLeftY: Int,
    color: Color,
) {
    val pxValue = with(LocalDensity.current) {
        unitLength.dp.toPx()
    }
    // https://www.hand2mind.com/glossary-of-hands-on-manipulatives/tangrams
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val rectSize = Size(pxValue, pxValue)
        val rectCenter = Offset(
            topLeftX.toFloat(),
            topLeftY.toFloat()
        )
        val rectTopLeft = Offset(
            rectCenter.x - (pxValue / 2),
            rectCenter.y - (pxValue / 2)
        )
        rotate(
            degrees = degreeRotation,
            pivot = rectCenter
        ) {
            drawRect(
                color = color,
                size = rectSize,
                topLeft = rectTopLeft
            )
        }
    }
}