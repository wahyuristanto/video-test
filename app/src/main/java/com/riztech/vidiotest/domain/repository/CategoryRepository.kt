package com.riztech.vidiotest.domain.repository

import com.nioso.core.base.BaseResponse
import com.nioso.core.base.BaseResult
import com.riztech.vidiotest.data.model.Response

interface CategoryRepository {
    suspend fun getCategory(): BaseResult<List<String>>
}