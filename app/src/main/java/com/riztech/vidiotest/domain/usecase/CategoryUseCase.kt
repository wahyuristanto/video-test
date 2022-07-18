package com.riztech.vidiotest.domain.usecase

import com.nioso.core.base.BaseResponse
import com.nioso.core.base.BaseResult
import com.riztech.vidiotest.data.model.Response
import com.riztech.vidiotest.domain.repository.CategoryRepository
import javax.inject.Inject

class CategoryUseCase @Inject constructor(val repository: CategoryRepository) {

    suspend fun getCategory(): BaseResult<List<String>>{
        return repository.getCategory()
    }
}