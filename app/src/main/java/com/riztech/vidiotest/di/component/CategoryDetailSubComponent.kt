package com.riztech.vidiotest.di.component

import com.riztech.vidiotest.di.module.BindCategoryDetailRepositoryModule
import com.riztech.vidiotest.presentation.category_detail.CategoryDetailFragment
import com.riztech.vidiotest.presentation.category_detail.CategoryDetailViewModel
import dagger.Subcomponent

@Subcomponent(modules = [BindCategoryDetailRepositoryModule::class])
interface CategoryDetailSubComponent {
    val viewModel: CategoryDetailViewModel
    fun inject(categoryDetailFragment: CategoryDetailFragment)
}