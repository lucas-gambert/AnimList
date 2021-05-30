package com.example.appliesiea.presentation.list

import com.example.appliesiea.Classes.Anime

sealed class AnimeModel

data class AnimeSuccess(val animeList: List<Anime>) : AnimeModel()
object AnimeLoader : AnimeModel()
object AnimeError : AnimeModel()