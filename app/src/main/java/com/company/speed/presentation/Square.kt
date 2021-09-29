package com.company.speed.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.drawscope.translate
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp


@Composable
fun Square(
    unitLength: Int,
    degreeRotation: Float,
    translationX: Float,
    translationY: Float,
    topLeftX: Int,
    topLeftY: Int,
    gradient: Brush,
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
        translate(left = translationX, top = translationY) {
            rotate(
                degrees = degreeRotation,
                pivot = rectCenter
            ) {

                drawRect(
                    brush = gradient,
                    size = rectSize,
                    topLeft = rectTopLeft
                )
                // Center debug
                drawRect(
                    color = Color.Black,
                    size = Size(5f, 5f),
                    topLeft = Offset(rectCenter.x - 2.5f, rectCenter.y - 2.5f)
                )
            }
        }
    }
}