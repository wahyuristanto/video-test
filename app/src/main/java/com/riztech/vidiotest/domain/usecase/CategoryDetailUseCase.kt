package com.riztech.vidiotest.domain.usecase

import com.nioso.core.base.BaseResult
import com.riztech.vidiotest.data.model.Response
import com.riztech.vidiotest.domain.repository.CategoryDetailRepository
import javax.inject.Inject

class CategoryDetailUseCase @Inject constructor(val repository: CategoryDetailRepository) {

    suspend fun getDetailCategory(category: String): BaseResult<Response.Jokes>{
        return repository.getCategoryJoke(category)
    }
}