package com.riztech.vidiotest.data.repository

import com.nioso.core.base.BaseResult
import com.riztech.vidiotest.data.model.Response
import com.riztech.vidiotest.domain.repository.CategoryDetailRepository

class FakeCategoryDetailRepository : CategoryDetailRepository {
    override suspend fun getCategoryJoke(category: String): BaseResult<Response.Jokes> {
        return BaseResult.Success(Response.Jokes(
            categories = arrayListOf("animal"),
            created_at = "2020-01-05 13:42:19.104863",
            icon_url = "https://assets.chucknorris.host/img/avatar/chuck-norris.png",
            id = "o-vfxwx6rgecuo_f5cecpq",
            updated_at = "2020-01-05 13:42:19.104863",
            url = "https://api.chucknorris.io/jokes/o-vfxwx6rgecuo_f5cecpq",
            value = "They say curiosity killed the cat. This is false. Chuck Norris killed the cat. Every single one of them."
        ))
    }
}