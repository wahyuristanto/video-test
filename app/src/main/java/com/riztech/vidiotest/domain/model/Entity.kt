package com.riztech.vidiotest.domain.model

import com.riztech.vidiotest.data.model.Response

sealed class Entity {

    data class Jokes(
        val categories: List<String>,
        val created_at: String,
        val icon_url: String,
        val id: String,
        val updated_at: String,
        val url: String,
        val value: String
    ): Entity()
}