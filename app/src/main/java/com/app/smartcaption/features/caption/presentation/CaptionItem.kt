package com.app.smartcaption.features.caption.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CopyAll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.smartcaption.R

@Composable
fun CaptionItem(caption: Caption) {
    Column(
        modifier = Modifier
            .padding(horizontal = 4.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = caption.title, color = MaterialTheme.colorScheme.onBackground)
            Icon(
                Icons.Default.CopyAll,
                modifier = Modifier
                    .rotate(180f)
                    .size(20.dp),
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = stringResource(R.string.copy_caption)
            )
        }
        Text(
            text = caption.description,
            color = MaterialTheme.colorScheme.onBackground.copy(0.7f),
            fontSize = 14.sp
        )
    }
}

@Preview
@Composable
private fun CaptionItemPreview() {
    CaptionItem(Caption("ABC", "DESC of ABC"))
}