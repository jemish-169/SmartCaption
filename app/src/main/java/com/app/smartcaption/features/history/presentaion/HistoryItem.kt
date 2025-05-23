package com.app.smartcaption.features.history.presentaion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.smartcaption.R

@Composable
fun HistoryItem(item: HistoryItem, isShowDelete: Boolean = true) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(R.drawable.home_screen_img),
            contentDescription = stringResource(R.string.home_screen_desc),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .clip(RoundedCornerShape(4.dp))
                .size(60.dp)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .weight(1f)
        ) {
            Text(
                text = item.title,
                color = MaterialTheme.colorScheme.onBackground,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = item.description,
                color = MaterialTheme.colorScheme.onBackground.copy(0.7f),
                fontSize = 14.sp,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }
        if (isShowDelete)
            Icon(
                painter = painterResource(R.drawable.delete_24),
                modifier = Modifier.size(20.dp),
                tint = MaterialTheme.colorScheme.onBackground,
                contentDescription = stringResource(R.string.delete_caption)
            )
    }
}

@Preview
@Composable
private fun HistoryItemPreview() {
    HistoryItem(HistoryItem(R.drawable.home_screen_img, "ABC", "DESC of ABC"))
}