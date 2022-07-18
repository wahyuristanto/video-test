package com.riztech.vidiotest.data.repository

import com.nioso.core.base.BaseResult
import com.riztech.vidiotest.domain.repository.CategoryRepository

class FakeCategoryRepository : CategoryRepository {
    override suspend fun getCategory(): BaseResult<List<String>> {
        return BaseResult.Success(arrayListOf("animal","career","celebrity","dev","explicit","fashion","food","history","money","movie","music","political","religion","science","sport","travel"))
    }
}