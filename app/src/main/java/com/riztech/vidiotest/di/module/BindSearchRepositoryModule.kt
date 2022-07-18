package com.riztech.vidiotest.di.module

import com.riztech.vidiotest.data.repository.SearchRepositoryImpl
import com.riztech.vidiotest.domain.repository.SearchRepository
import dagger.Binds
import dagger.Module

@Module
abstract class BindSearchRepositoryModule {
    @Binds
    abstract fun provideSearchRepository(searchRepositoryImpl: SearchRepositoryImpl): SearchRepository
}