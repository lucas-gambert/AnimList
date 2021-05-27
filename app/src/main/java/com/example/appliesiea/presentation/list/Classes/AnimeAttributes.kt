package com.example.appliesiea.presentation.list.Classes

import java.util.*

data class AnimeAttributes(
    val titles: AnimeTitles,
    val posterImage: AnimeImage,
    val synopsis: String,
    val startDate: String,
    val endDate: String,
    val status: String,
    val averageRating: String
)
