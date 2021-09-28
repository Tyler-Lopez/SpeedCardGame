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
import androidx.compose.ui.graphics.ClipOp
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
fun Parallelogram(
    unitLength: Int,
    degreeRotation: Float,
    topLeftX: Int,
    topLeftY: Int,
    gradient: Brush
) {
    val pxValue = with(LocalDensity.current) {
        unitLength.dp.toPx()
    }
    // https://www.hand2mind.com/glossary-of-hands-on-manipulatives/tangrams
    val rectSize = Size(pxValue, pxValue)
    Canvas(
        modifier = Modifier
            .fillMaxSize()
    ) {
        val parallelogramSize = Size(pxValue, pxValue)
        val parallelogramCenter = Offset(
            topLeftX.toFloat(),
            topLeftY.toFloat()
        )
        val parallelogramTopLeft = Offset(
            topLeftX.toFloat() - (pxValue / 2),
            topLeftY.toFloat() - (pxValue / 2)
        )
        // https://www.quora.com/Is-there-a-way-to-find-the-other-two-equal-sides-of-a-right-triangle-with-only-the-hypotenuse-and-no-height-given
        val sidesLength = pxValue / sqrt(2f)
        val pxHypotenuse = sqrt(pxValue.pow(2) + pxValue.pow(2))
        rotate(
            degrees = degreeRotation,
            pivot = parallelogramCenter
        ) {

            translate(
                left = sidesLength,
                top = sidesLength
            ) {
                rotate(
                    degrees = 0f,
                    pivot = parallelogramCenter
                ) {
                    val path = Path()

                    path.addRect(
                        rect = Rect(
                            offset = Offset(parallelogramCenter.x - (pxHypotenuse / 2), parallelogramCenter.y),
                            size = Size(pxHypotenuse, pxHypotenuse)
                        )
                    )
                    clipPath(path, clipOp = ClipOp.Difference) {
                        rotate(
                            degrees = 45f,
                            pivot = parallelogramCenter
                        ) {
                            drawRect(
                                brush = gradient,
                                size = rectSize,
                                topLeft = parallelogramTopLeft
                            )
                        }
                    }
                }
            }

            val path = Path()
            path.addRect(
                rect = Rect(
                    offset = Offset(parallelogramCenter.x - (pxHypotenuse / 2), parallelogramCenter.y),
                    size = Size(pxHypotenuse, pxHypotenuse)
                )
            )
            clipPath(path) {
                rotate(
                    degrees = 45f,
                    pivot = parallelogramCenter
                ) {
                    drawRect(
                        brush = gradient,
                        size = rectSize,
                        topLeft = parallelogramTopLeft
                    )
                }

            }
        }
    }
}