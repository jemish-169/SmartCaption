package com.app.smartcaption.features.upload_img.presentaion

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.smartcaption.R
import com.app.smartcaption.common.presentation.HeaderBackIcon

@Composable
fun UploadScreen(onClose: () -> Unit, onGenerateCaption: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(top = 12.dp, bottom = 24.dp, start = 12.dp, end = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        val isImageUploaded by remember { mutableStateOf(false) }

        HeaderBackIcon(
            headerText = stringResource(R.string.upload_a_photo),
            onBackClick = onClose,
            iconDesc = stringResource(R.string.close_icon),
            startIcon = Icons.Default.Close
        )

        Spacer(modifier = Modifier.height(32.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .dashedBorder(
                    color = MaterialTheme.colorScheme.onBackground.copy(0.2f),
                    radius = 8.dp
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = stringResource(R.string.lets_analyze_image_desc),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Bold
                )

                Text(
                    text = stringResource(R.string.upload_a_photo_from_device),
                    style = MaterialTheme.typography.bodySmall
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {},
                    content = {
                        Text(stringResource(R.string.choose_from_gallery))
                    },
                    colors = ButtonDefaults.buttonColors()
                        .copy(
                            contentColor = MaterialTheme.colorScheme.onBackground,
                            containerColor = MaterialTheme.colorScheme.onBackground.copy(0.15f)
                        )
                )
            }
        }

        if (isImageUploaded) {
            Image(
                painter = painterResource(R.drawable.home_screen_img),
                contentDescription = stringResource(R.string.home_screen_desc),
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onGenerateCaption,
            modifier = Modifier.fillMaxWidth(),
            content = {
                Text(
                    text = stringResource(R.string.next_generate_caption),
                    color = MaterialTheme.colorScheme.background
                )
            }
        )
    }
}

@Preview
@Composable
private fun UploadScreenPreview() {
    UploadScreen(onClose = {}, onGenerateCaption = {})
}