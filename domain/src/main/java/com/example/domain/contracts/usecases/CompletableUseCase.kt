package com.example.domain.contracts.usecases

import io.reactivex.Completable

interface CompletableUseCase<P> {
    fun execute(parameter: P): Completable

}