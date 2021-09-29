package com.company.speed.presentation

import android.os.PersistableBundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.dp
import com.company.speed.ui.theme.*
import java.lang.Math.cos
import java.lang.Math.tan
import kotlin.math.*

@Composable
fun Heart(
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val centerX = this.constraints.maxWidth / 2
        val centerY = (this.constraints.maxHeight / 1.5).toInt()
        val unitLength = (sqrt(this.constraints.maxWidth.toDouble() * this.constraints.maxHeight) / 20).toInt()









        /*
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
        )*/
        val pxHypotenuse = sqrt(unitLength.toFloat().pow(2) + unitLength.toFloat().pow(2))
        val triangleHeight = sqrt((unitLength.toFloat().pow(2f)) - ((0.5f * pxHypotenuse).pow(2.0f)))
        val translateY = sqrt(triangleHeight.pow(2f) + unitLength.toFloat().pow(2f))

        val pxValue = with(LocalDensity.current) {
            unitLength.dp.toPx()
        }
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
        val lgPxHypotenuse = sqrt((2 * unitLength).toFloat().pow(2) + (2 * unitLength).toFloat().pow(2))
        val lgTriangleHeight = sqrt(((2 * unitLength).toFloat().pow(2f)) - ((0.5f * pxHypotenuse).pow(2.0f)))
        // https://www.mathsisfun.com/algebra/trig-finding-side-right-triangle.html

        val distanceToCenterSquare = sin(.78539816f) * (pxValue)
        SmallTriangle(
            unitLength = unitLength,
            degreeRotation = 90f,
            translationX = (distanceToCenterSquare/2f).toFloat(),
            translationY = (-distanceToCenterSquare).toFloat(),
            topLeftX = centerX,
            topLeftY = centerY,
            gradient = Brush.verticalGradient(
                listOf(
                    RedFireBrick,
                    RedCrimson
                )
            )
        )

        val mdPxHypotenuse = sqrt((1.5f * unitLength).toFloat().pow(2) + (1.5f * unitLength).toFloat().pow(2))
        val mdTriangleHeight = sqrt(((1.5f * unitLength).toFloat().pow(2f)) - ((0.5f * mdPxHypotenuse).pow(2.0f)))
        val mdAdjustment = ((mdTriangleHeight/2f)/sqrt(2f))


        MediumTriangle(
            preUnitLength = unitLength,
            degreeRotation = 135f,
            translationX = (1.5f*distanceToCenterSquare),
            translationY = (-1.5f*distanceToCenterSquare).toFloat(),
            topLeftX = centerX,
            topLeftY = centerY,
            gradient = Brush.verticalGradient(
                listOf(
                    RedPersianRed,
                    RedJasper
                )
            )
        )
/*
        SmallTriangle(
            unitLength = unitLength,
            degreeRotation = 270f,
            translationX = (triangleHeight * 1.5).toFloat() + distanceToCenterSquare,
            translationY = (-pxHypotenuse - triangleHeight).toFloat(),
            topLeftX = centerX,
            topLeftY = centerY,
            gradient = Brush.verticalGradient(
                listOf(
                    Color.Transparent,
                    RedCrimson
                )
            )
        )
        SmallTriangle(
            unitLength = unitLength,
            degreeRotation = 0f,
            translationX = (triangleHeight * 1.5).toFloat() + (distanceToCenterSquare * 1.5f),
            translationY = (-pxHypotenuse - triangleHeight - (distanceToCenterSquare * 0.5)).toFloat(),
            topLeftX = centerX,
            topLeftY = centerY,
            gradient = Brush.verticalGradient(
                listOf(
                    Color.Transparent,
                    RedCrimson
                )
            )
        )*/
        LargeTriangle(
            preUnitLength = unitLength,
            degreeRotation = 0f,
            translationX = -distanceToCenterSquare,
            translationY = -distanceToCenterSquare,
            topLeftX = centerX,
            topLeftY = centerY.toInt(),

            gradient = Brush.verticalGradient(
                listOf(
                    RedLightSalmon,
                    RedCrimson
                )
            )
        )

        LargeTriangle(
            preUnitLength = unitLength,
            degreeRotation = 180f,
            translationX = +distanceToCenterSquare,
            translationY = -(distanceToCenterSquare + (2 * distanceToCenterSquare)),
            topLeftX = centerX,
            topLeftY = centerY.toInt(),

            gradient = Brush.verticalGradient(
                listOf(
                    RedRedOrange,
                    RedTomato
                )
            )
        )
        LargeTriangle(
            preUnitLength = unitLength,
            degreeRotation = 180f,
            translationX = -distanceToCenterSquare,
            translationY = -(distanceToCenterSquare + (2 * distanceToCenterSquare)),
            topLeftX = centerX,
            topLeftY = centerY.toInt(),

            gradient = Brush.verticalGradient(
                listOf(
                    RedPortlandOrange,
                    RedCrimson
                )
            )
        )
        SmallTriangle(
            unitLength = unitLength,
            degreeRotation = 180f,
            translationX = (distanceToCenterSquare).toFloat(),
            translationY = (-3.5f * distanceToCenterSquare).toFloat(),
            topLeftX = centerX,
            topLeftY = centerY,
            gradient = Brush.verticalGradient(
                listOf(
                    RedRed,
                    RedRedOrange,
                    RedPortlandOrange
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
*/


    }
}