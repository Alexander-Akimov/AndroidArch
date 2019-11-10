package com.example.domain.contracts.usecases

//Output port
interface CompletableUseCaseSimple<P> {

    interface Callback {
        fun onSuccess()
        fun onError(throwable: Throwable)
    }

    fun execute(parameter: P, callback: Callback)
}