package com.example.domain.contracts.usecases

import io.reactivex.Single

interface UseCase<P, R> {

    fun execute(parameter: P): Single<R>
}