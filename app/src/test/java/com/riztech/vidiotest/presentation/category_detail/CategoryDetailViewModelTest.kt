package com.riztech.vidiotest.presentation.category_detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.google.common.truth.Truth.assertThat
import com.nioso.client.feature_login.MainCoroutineRule
import com.nioso.client.feature_login.getOrAwaitValueTest
import com.nioso.core.base.BaseResult
import com.riztech.vidiotest.data.repository.FakeCategoryDetailRepository
import com.riztech.vidiotest.domain.usecase.CategoryDetailUseCase
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CategoryDetailViewModelTest {
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    lateinit var viewModel: CategoryDetailViewModel
    lateinit var useCase: CategoryDetailUseCase

    @Before
    fun setup(){
        useCase = CategoryDetailUseCase(FakeCategoryDetailRepository())
        viewModel = CategoryDetailViewModel(useCase)
    }

    @Test
    fun `get category joke`(){
        viewModel.getCategoryJoke("animal")

        val response = viewModel.responseCategory.getOrAwaitValueTest()

        val baseResult = response.showOnce()

        assertThat(baseResult).isInstanceOf(BaseResult.Success::class.java)
        assertThat((baseResult as BaseResult.Success).data).isNotNull()
        assertThat((baseResult as BaseResult.Success).data?.categories.get(0)).isEqualTo("animal")
    }

}