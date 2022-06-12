package com.ismailhakkiaydin.rickandmorty.base.dispatcher

import kotlinx.coroutines.CoroutineDispatcher


interface DispatcherProvider {
    val main: CoroutineDispatcher
    val io: CoroutineDispatcher
    val default: CoroutineDispatcher
}