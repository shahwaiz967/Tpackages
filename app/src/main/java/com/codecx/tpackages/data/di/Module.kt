package com.codecx.tpackages.data.di

import com.codecx.tpackages.data.repo.DataUsageRepo
import com.codecx.tpackages.data.repo.FourGOnlyRepo
import com.codecx.tpackages.data.repo.SpeedTestRepo
import com.codecx.tpackages.features.viewModel.DataUsageViewModel
import com.codecx.tpackages.features.viewModel.FourGOnlyViewModel
import com.codecx.tpackages.features.viewModel.SpeedTestViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    viewModelOf(::DataUsageViewModel)
    viewModelOf(::FourGOnlyViewModel)
    factoryOf(::DataUsageRepo)
    factoryOf(::FourGOnlyRepo)
    viewModelOf(::SpeedTestViewModel)
    factoryOf(::SpeedTestRepo)

}


