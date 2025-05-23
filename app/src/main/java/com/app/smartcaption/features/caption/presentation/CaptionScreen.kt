package com.app.smartcaption.features.caption.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.smartcaption.R
import com.app.smartcaption.common.presentation.HeaderBackIcon
import com.app.smartcaption.sample_data.captionList
import com.app.smartcaption.sample_data.categoryList

@Composable
fun CaptionScreen(onBack: () -> Unit) {

    val selectedCategory by remember { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 12.dp, bottom = 24.dp, start = 12.dp, end = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        HeaderBackIcon(
            headerText = stringResource(R.string.caption),
            onBackClick = onBack,
            iconDesc = stringResource(R.string.back_icon),
            startIcon = Icons.Default.ArrowBackIosNew
        )

        Spacer(modifier = Modifier.height(12.dp))

        Image(
            painter = painterResource(R.drawable.home_screen_img),
            contentDescription = stringResource(R.string.home_screen_image),
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(300.dp)
                .clip(RoundedCornerShape(8.dp))
                .fillMaxWidth()
        )


        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            contentPadding = PaddingValues(horizontal = 4.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            itemsIndexed(items = categoryList) { index, category ->
                CategoryItem(category, index == selectedCategory)
            }
        }
        HorizontalDivider()

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 8.dp),
            modifier = Modifier.weight(1f)
        ) {
            itemsIndexed(captionList) { _, caption ->
                CaptionItem(caption)
            }
        }

        Button(
            modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
            onClick = {},
            content = {
                Text(
                    text = stringResource(R.string.re_generate),
                    color = MaterialTheme.colorScheme.background
                )
            }
        )
    }
}

@Preview
@Composable
private fun UploadScreenPreview() {
    CaptionScreen(onBack = {})
}