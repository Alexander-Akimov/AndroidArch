package com.example.domain.contracts.usecases

//Input port
interface UseCaseSimple<P, R> {

    interface Callback<R> {
        fun onSuccess(result: R)
        fun onError(throwable: Throwable)
    }

    fun execute(parameter: P, callback: Callback<R>)
}