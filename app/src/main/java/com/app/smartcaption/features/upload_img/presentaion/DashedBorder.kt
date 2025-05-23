package com.app.smartcaption.features.upload_img.presentaion

import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

fun Modifier.dashedBorder(
    color: Color,
    strokeWidth: Dp = 2.dp,
    dotSpacing: Dp = 4.dp,
    radius: Dp = 0.dp
): Modifier = this.then(
    Modifier.drawBehind {
        val stroke = strokeWidth.toPx()
        val spacing = dotSpacing.toPx()

        val pathEffect = PathEffect.dashPathEffect(
            floatArrayOf(stroke, spacing), 0f
        )

        drawRoundRect(
            color = color,
            size = size,
            cornerRadius = CornerRadius(radius.toPx()),
            style = Stroke(width = stroke, pathEffect = pathEffect, cap = StrokeCap.Round)
        )
    }
)