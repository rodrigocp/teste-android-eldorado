package br.com.rcp.domain.usecases

interface UseCase<T, R> {
    suspend fun invoke(param: T): R
}