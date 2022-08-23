package com.dilara.vitrinovanew.di


import com.dilara.vitrinovanew.data.repository.VitrinovaRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideVitrinovaRepository():VitrinovaRepository{
        return VitrinovaRepository()
    }
}