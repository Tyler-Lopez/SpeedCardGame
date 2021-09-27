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
    val rectSize = Size(pxValue, pxValue)
    val canvasSize = Size(pxValue + pxValue / 2, pxValue + pxValue / 2)
    Canvas(
        modifier = Modifier
            .size(unitLength.dp + (unitLength.dp / 2))
            .offset((topLeftX).dp, (topLeftY).dp)
    ) {
        rotate(
            degrees = degreeRotation,
            pivot = center
        ) {
            val path = Path()
            path.addRect(
                rect = Rect(
                    offset = Offset(this.center.x - (canvasSize.width / 2f), this.center.y),
                    size = canvasSize
                )
            )
            drawRect(
                color = color,
                size = rectSize,
                topLeft = Offset(
                    this.center.x - (rectSize.width / 2f),
                    this.center.y - (rectSize.height / 2f)
                )
            )
        }
    }
}