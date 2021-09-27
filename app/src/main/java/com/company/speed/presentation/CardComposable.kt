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
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.DrawStyle
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
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
fun MyCanvas() {
    Box(modifier = Modifier.fillMaxSize().padding(20.dp)) {
        PlayingCard(modifier = Modifier
            .fillMaxSize()
            .align(alignment = Alignment.Center))
    }
}

@Composable
fun PlayingCard(
    modifier: Modifier = Modifier,
) {
    BoxWithConstraints(modifier = modifier.fillMaxSize()) {
        val cardWidth = constraints.maxWidth.toFloat()
        val cardHeight = cardWidth * 1.25f
        Canvas(modifier = modifier) {
                drawRoundRect(
                    color = Color.LightGray,
                    cornerRadius = CornerRadius(100f, 100f),
                    size = Size(cardWidth, cardHeight)
                )
            }
        }
    }
