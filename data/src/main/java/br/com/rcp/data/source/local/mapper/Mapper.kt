package br.com.rcp.data.source.local.mapper

interface Mapper<S, D> {
    fun toDomain(entity: S): D
    fun toEntity(domain: D): S
}