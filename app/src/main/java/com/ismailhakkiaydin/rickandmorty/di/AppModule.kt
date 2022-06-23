package com.ismailhakkiaydin.rickandmorty.di

import com.ismailhakkiaydin.rickandmorty.base.dispatcher.DispatcherImpl
import com.ismailhakkiaydin.rickandmorty.base.dispatcher.DispatcherProvider
import com.ismailhakkiaydin.rickandmorty.data.repository.CharacterRepository
import com.ismailhakkiaydin.rickandmorty.data.service.CharacterService
import com.ismailhakkiaydin.rickandmorty.util.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCharacterRepository(
        api: CharacterService,
        dispatcher: DispatcherProvider
    ) = CharacterRepository(api = api, dispatcher = dispatcher)

    @Provides
    @Singleton
    fun provideCharacterService(): CharacterService {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(Constant.BASE_URL)
            .build()
            .create(CharacterService::class.java)
    }

    @Provides
    @Singleton
    fun provideDispatcher(dispatcherImpl: DispatcherImpl): DispatcherProvider = dispatcherImpl
}