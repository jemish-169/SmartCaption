package com.app.smartcaption.features.caption.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CategoryItem(category: String, isSelected: Boolean) {
    Column {
        val textColor = MaterialTheme.colorScheme.onBackground
        var textWidth by remember { mutableStateOf(0.dp) }
        val density = LocalDensity.current
        Text(
            text = category,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            color = if (isSelected) textColor else textColor.copy(0.7f),
            onTextLayout = { textLayoutResult ->
                with(density) {
                    textWidth = textLayoutResult.size.width.toDp()
                }
            }

        )
        if (isSelected) {
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = Modifier
                    .width(if (textWidth > 0.dp) textWidth else 40.dp)
                    .height(2.dp)
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
    }
}


@Preview
@Composable
private fun CategoryItemPreview() {
    CategoryItem("Category", true)
}