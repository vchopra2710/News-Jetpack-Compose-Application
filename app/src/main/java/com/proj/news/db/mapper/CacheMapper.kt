package com.proj.news.db.mapper

interface CacheMapper<DtoModel, CacheModel> {
    fun mapToCacheModel(dto: DtoModel): CacheModel
    fun mapFromCacheModel(cache: CacheModel): DtoModel
}