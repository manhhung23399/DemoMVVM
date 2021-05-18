package com.example.demomvvm.di

import com.example.demomvvm.data.MovieDataSource
import com.example.demomvvm.data.MovieRemoteDataSource
import com.example.demomvvm.data.repository.MovieRepository
import com.example.demomvvm.data.repository.MovieRepositoryImpl
import org.koin.dsl.module

val sourceModule = module {
    single<MovieDataSource> { MovieRemoteDataSource(get()) }
    single<MovieRepository> { MovieRepositoryImpl(get()) }
}
