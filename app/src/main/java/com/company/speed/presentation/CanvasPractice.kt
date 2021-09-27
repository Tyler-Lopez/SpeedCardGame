package com.company.speed.presentation

import android.graphics.Paint
import android.os.CountDownTimer
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.*
import kotlin.random.Random

/*

This project is for learning CANVAS

Design inspiration: https://www.behance.net/gallery/19253089/Flat-design-Playing-Cards

 */

@Composable
fun MyCanvasPractice() {
    Box(modifier = Modifier.fillMaxSize()) {
        Scale(modifier = Modifier
            .fillMaxWidth()
            .align(alignment = Alignment.Center)) {

        }
    }
}

@Composable
fun Scale(
    modifier: Modifier = Modifier,
    style: ScaleStyle = ScaleStyle(),
    minWeight: Int = 20,
    maxWeight: Int = 250,
    initialWeight: Int = 80,
    onWeightChange: (Int) -> Unit
) {
    val radius = style.radius
    val scaleWidth = style.scaleWidth
    var center by remember {
        mutableStateOf(Offset.Zero)
    }
    var circleCenter by remember {
        mutableStateOf(Offset.Zero)
    }
    var angle by remember {
        mutableStateOf(0f)
    }
    Canvas(modifier = modifier) {
        center = this.center
        circleCenter = Offset(
            center.x,
            scaleWidth.toPx() / 2f + radius.toPx()
        )
        val outerRadius = radius.toPx() + scaleWidth.toPx() / 2f
        val innerRadius = radius.toPx() - scaleWidth.toPx() / 2f

        drawContext.canvas.nativeCanvas.apply {
            // This allows us to use shadows, more options
            drawCircle(
                circleCenter.x,
                circleCenter.y,
                radius.toPx(),
                Paint().apply {
                    strokeWidth = scaleWidth.toPx() + 50f
                    color = android.graphics.Color.argb(20, 0, 0, 0)
                    setStyle(Paint.Style.STROKE)
                },
            )
            drawCircle(
                circleCenter.x,
                circleCenter.y,
                radius.toPx(),
                Paint().apply {
                    strokeWidth = scaleWidth.toPx()
                    color = android.graphics.Color.argb(80, 255, 255, 255)
                    setStyle(Paint.Style.STROKE)
                }
            )
            for (i in minWeight..maxWeight) {
                val angleInDegrees = (i - initialWeight + angle - 90)
                val angleInRadians = angleInDegrees * (PI / 180f).toFloat()
                val lineType = when {
                    i % 10 == 0 -> LineType.TenStep
                    i % 5 == 0 -> LineType.FiveStep
                    else -> LineType.Normal
                }
                val lineColor = when(lineType) {
                    LineType.Normal -> style.normalLineColor
                    LineType.FiveStep -> style.fiveStepLineColor
                    LineType.TenStep -> style.tenStepLineColor
                }
                val lineLength = when(lineType) {
                    LineType.Normal -> style.normalLineLength.toPx()
                    LineType.FiveStep -> style.fiveStepLineLength.toPx()
                    LineType.TenStep -> style.tenStepLineLength.toPx()
                }
                val radiusOfLineStart = outerRadius - lineLength
                val lineStart = Offset(
                    x = radiusOfLineStart * cos(angleInRadians) + circleCenter.x,
                    y = radiusOfLineStart * sin(angleInRadians) + circleCenter.y
                )
                val lineEnd = Offset(
                    x = outerRadius * cos(angleInRadians) + circleCenter.x,
                    y = outerRadius * sin(angleInRadians) + circleCenter.y
                )
                drawLine(
                    color = lineColor,
                    start = lineStart,
                    end = lineEnd,
                    strokeWidth = 1.dp.toPx()
                )
            }
        }
    }
}

sealed class LineType {
    object Normal : LineType()
    object FiveStep : LineType()
    object TenStep : LineType()
}

data class ScaleStyle(
    val scaleWidth: Dp = 200.dp,
    val radius: Dp = 550.dp,
    val normalLineColor: Color = Color.LightGray,
    val fiveStepLineColor: Color = Color.Green,
    val tenStepLineColor: Color = Color.Black,
    val normalLineLength: Dp = 15.dp,
    val fiveStepLineLength: Dp = 25.dp,
    val tenStepLineLength: Dp = 35.dp,
    val scaleIndicatorColor: Color = Color.Green,
    val scaleIndicatorLength: Dp = 60.dp,
    val textSize: TextUnit = 18.sp,
)