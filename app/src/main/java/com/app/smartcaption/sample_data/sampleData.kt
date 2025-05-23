package com.app.smartcaption.sample_data

import com.app.smartcaption.R
import com.app.smartcaption.features.caption.presentation.Caption
import com.app.smartcaption.features.history.presentaion.HistoryItem

val historyItemList = listOf(
    HistoryItem(
        img = R.drawable.home_screen_img,
        title = "Golden Sunset",
        description = "The golden sun slowly dips below the horizon, painting the sky in shades of orange and purple beauty."
    ),
    HistoryItem(
        img = R.drawable.home_screen_img,
        title = "City at Night",
        description = "Bright city lights shimmer as people bustle through neon-lit streets under the dark, starless night sky."
    ),
    HistoryItem(
        img = R.drawable.home_screen_img,
        title = "Morning in the Forest",
        description = "Sunlight filters through tall trees, casting long shadows and illuminating the path with a golden morning glow."
    ),
    HistoryItem(
        img = R.drawable.home_screen_img,
        title = "Waves on the Shore",
        description = "Gentle waves roll onto the sandy beach, leaving trails of foam and seashells under the warm afternoon sun."
    ),
    HistoryItem(
        img = R.drawable.home_screen_img,
        title = "Snowy Mountain Escape",
        description = "Snow blankets the towering mountains, reflecting sunlight while the crisp air whispers through the silent alpine valley."
    )
)

val categoryList = listOf(
    "Formal", "Friendly", "Witty", "Poetic", "Professional"
)

val captionList = listOf(
    Caption(
        title = "Golden Sunset",
        description = "The golden sun slowly dips below the horizon, painting the sky in shades of orange and purple beauty."
    ),
    Caption(
        title = "City at Night",
        description = "Bright city lights shimmer as people bustle through neon-lit streets under the dark, starless night sky."
    ),
    Caption(
        title = "Morning in the Forest",
        description = "Sunlight filters through tall trees, casting long shadows and illuminating the path with a golden morning glow."
    ),
    Caption(
        title = "Waves on the Shore",
        description = "Gentle waves roll onto the sandy beach, leaving trails of foam and seashells under the warm afternoon sun."
    ),
    Caption(
        title = "Snowy Mountain Escape",
        description = "Snow blankets the towering mountains, reflecting sunlight while the crisp air whispers through the silent alpine valley."
    )
)