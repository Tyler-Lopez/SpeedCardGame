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
import kotlin.math.pow
import kotlin.math.sqrt


@Composable
fun SmallTriangle(
    unitLength: Int,
    degreeRotation: Float,
    translationX: Float,
    translationY: Float,
    topLeftX: Int,
    topLeftY: Int,
    gradient: Brush
) {
    val pxValue = with(LocalDensity.current) {
        unitLength.dp.toPx()
    }

    Canvas(
        modifier = Modifier.fillMaxSize()
    ) {
        // https://www.hand2mind.com/glossary-of-hands-on-manipulatives/tangrams
        val rectSize = Size(pxValue, pxValue)
        val rectCenter = Offset(
            topLeftX.toFloat(),
            topLeftY.toFloat()
        )

        val pxHypotenuse = sqrt(pxValue.pow(2) + pxValue.pow(2))
        val triangleHeight = sqrt((pxValue.pow(2f)) - ((0.5f * pxHypotenuse).pow(2.0f)))
        val triangleCenter = Offset(
            rectCenter.x,
            rectCenter.y + (triangleHeight / 2)
        )
        val translatedPivot = Offset(
            triangleCenter.x,
            triangleCenter.y -(0.5f * triangleHeight)
        )
        translate(left = translationX, top = translationY) {
            rotate(
                degrees = degreeRotation,
                pivot = translatedPivot
            ) {

                translate(top = -(0.5f * triangleHeight)) {
                    val path = Path()
                    path.addRect(
                        rect = Rect(
                            offset = Offset(rectCenter.x - (pxHypotenuse / 2), rectCenter.y),
                            size = Size(pxHypotenuse, pxHypotenuse)
                        )
                    )
                    clipPath(path) {
                        rotate(
                            degrees = 45f,
                            pivot = rectCenter
                        ) {
                            drawRect(
                                brush = gradient,
                                size = rectSize,
                                topLeft = Offset(
                                    triangleCenter.x - (rectSize.width / 2f),
                                    rectCenter.y - (rectSize.height / 2f)
                                )
                            )

                        }
                    }
                    drawRect(
                        color = Color.Black,
                        size = Size(5f, 5f),
                        topLeft = Offset(triangleCenter.x - 2.5f, triangleCenter.y - 2.5f)
                    )

                }
                drawRect(
                    color = Color.Blue,
                    size = Size(5f, 5f),
                    topLeft = translatedPivot
                )
            }
        }
    }
}