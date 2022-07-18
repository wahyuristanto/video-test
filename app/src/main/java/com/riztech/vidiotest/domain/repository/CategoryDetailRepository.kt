package com.riztech.vidiotest.domain.repository

import com.nioso.core.base.BaseResult
import com.riztech.vidiotest.data.model.Response

interface CategoryDetailRepository {
    suspend fun getCategoryJoke(category: String): BaseResult<Response.Jokes>
}