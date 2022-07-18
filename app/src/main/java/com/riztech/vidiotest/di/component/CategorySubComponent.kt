package com.riztech.vidiotest.di.component

import com.riztech.vidiotest.di.module.BindCategoryRepositoryModule
import com.riztech.vidiotest.presentation.category_list.CategoryFragment
import com.riztech.vidiotest.presentation.category_list.CategoryViewModel
import dagger.Subcomponent

@Subcomponent(modules = [BindCategoryRepositoryModule::class])
interface CategorySubComponent {
    val viewModel: CategoryViewModel
    fun inject(categoryFragment: CategoryFragment)
}