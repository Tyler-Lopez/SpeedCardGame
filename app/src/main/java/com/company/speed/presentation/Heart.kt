package com.company.speed.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.company.speed.ui.theme.*
import kotlin.math.pow
import kotlin.math.sqrt

@Composable
fun Heart(
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val centerX = this.constraints.maxWidth / 2
        val centerY = this.constraints.maxHeight / 2
        val unitLength = (sqrt(this.constraints.maxWidth.toDouble() * this.constraints.maxHeight) / 20).toInt()








        Square(
            unitLength = unitLength,
            degreeRotation = 45f,
            translationX = 0f,
            translationY = 0f,
            topLeftX = centerX,
            topLeftY = centerY,
            gradient = Brush.verticalGradient(
                listOf(
                    RedJasper,
                    RedPersianRed
                )
            )
        )
        Square(
            unitLength = unitLength,
            degreeRotation = 45f,
            translationX = 2f*unitLength.toFloat(),
            translationY =  2f*unitLength.toFloat(),
            topLeftX = centerX,
            topLeftY = centerY,
            gradient = Brush.verticalGradient(
                listOf(
                    Color.Cyan,
                    Color.Blue
                )
            )
        )

        MediumTriangle(
            preUnitLength = unitLength,
            degreeRotation = 135f,
            topLeftX = centerX + (3 * unitLength),
            topLeftY = centerY - (2 * unitLength),
            gradient = Brush.verticalGradient(
                listOf(
                    RedRed,
                    RedSpanishRed
                )
            )

        )
        /*
        Parallelogram(
            unitLength = unitLength,
            degreeRotation = 0f,
            topLeftX = centerX + (2 * unitLength),
            topLeftY = centerY - (3 * unitLength),
            gradient = Brush.verticalGradient(
                listOf(
                    RedRedOrange,
                    RedPortlandOrange
                )
            )
        )
        LargeTriangle(
            preUnitLength = unitLength,
            degreeRotation = 180f,
            topLeftX = centerX - (2 * unitLength),
            topLeftY = centerY - (9 * unitLength).toInt(),

            gradient = Brush.verticalGradient(
                listOf(
                    RedTomato,
                    RedCrimson
                )
            )
        )
        LargeTriangle(
            preUnitLength = unitLength,
            degreeRotation = 0f,
            topLeftX = centerX,
            topLeftY = centerY,
            gradient = Brush.verticalGradient(
                listOf(
                    RedRed,
                    RedIndianRed
                )
            )
        )
        SmallTriangle(
            unitLength = unitLength,
            degreeRotation = 180f,
            translationX = 0f,
            translationY = 0f,
            topLeftX = centerX,
            topLeftY = centerY,
            gradient = Brush.verticalGradient(
                listOf(
                    RedDarkSalmon,
                    RedPortlandOrange
                )
            )

        )

        val pxHypotenuse = sqrt(unitLength.toFloat().pow(2) + unitLength.toFloat().pow(2))
        val triangleHeight = sqrt((unitLength.toFloat().pow(2f)) - ((0.5f * pxHypotenuse).pow(2.0f)))
        val translateY = sqrt(triangleHeight.pow(2f) + unitLength.toFloat().pow(2f))
        SmallTriangle(
            unitLength = unitLength,
            degreeRotation = 90f,
            translationX = unitLength.toFloat(),
            translationY = -(2.1f*unitLength).toFloat(),
            topLeftX = centerX,
            topLeftY = centerY,
            gradient = Brush.verticalGradient(
                listOf(
                    RedRed,
                    RedIndianRed
                )
            )
        )*/

    }
}