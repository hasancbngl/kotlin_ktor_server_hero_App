package com.hasancbngl.di

import com.hasancbngl.repository.HeroRepository
import com.hasancbngl.repository.HeroRepositoryAlternative
import com.hasancbngl.repository.HeroRepositoryAlternativeImp
import com.hasancbngl.repository.HeroRepositoryImp
import org.koin.dsl.module

val koinModule = module {
    single<HeroRepository> {
        HeroRepositoryImp()
    }
    single<HeroRepositoryAlternative> {
        HeroRepositoryAlternativeImp()
    }
}