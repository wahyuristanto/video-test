package com.riztech.vidiotest.presentation.category_list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.nioso.client.feature_login.MainCoroutineRule
import com.nioso.client.feature_login.getOrAwaitValueTest
import com.nioso.core.base.BaseResult
import com.riztech.vidiotest.data.repository.FakeCategoryRepository
import com.riztech.vidiotest.domain.usecase.CategoryUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CategoryViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var viewModel: CategoryViewModel
    lateinit var useCase: CategoryUseCase

    @Before
    fun setup(){
        useCase = CategoryUseCase(FakeCategoryRepository())
        viewModel = CategoryViewModel(useCase)
    }

    @Test
    fun `get category from api`(){

        viewModel.getCategory()

        val response = viewModel.responseCategory.getOrAwaitValueTest()

        val baseResult = response.showOnce()

        assertThat(baseResult).isInstanceOf(BaseResult.Success::class.java)
        assertThat((baseResult as BaseResult.Success).data?.size).isEqualTo(16)



    }

}